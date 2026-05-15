package com.channapatna.nammapride.ui.ai

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.channapatna.nammapride.BuildConfig
import com.channapatna.nammapride.data.AppData
import com.channapatna.nammapride.databinding.FragmentAiBinding
import com.channapatna.nammapride.model.ChatMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

class AiFragment : Fragment(), TextToSpeech.OnInitListener {

    private var _binding: FragmentAiBinding? = null
    private val binding get() = _binding!!

    private lateinit var tts: TextToSpeech
    private var isTtsReady = false
    private var speechRecognizer: SpeechRecognizer? = null
    private var isListening = false

    private val messages = mutableListOf<ChatMessage>()
    private lateinit var chatAdapter: ChatAdapter

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tts = TextToSpeech(requireContext(), this)
        setupChat()
        setupQuickPrompts()
        setupButtons()
    }

    private fun setupChat() {
        chatAdapter = ChatAdapter(messages)
        binding.rvChat.apply {
            layoutManager = LinearLayoutManager(requireContext()).also {
                it.stackFromEnd = true
            }
            adapter = chatAdapter
        }
        addBotMessage(
            "👋 Namaskara! I'm NammaBot, your AI heritage guide for Channapatna crafts. " +
                    "I can help you learn about artisans, the lac-dyeing process, GI certification, and much more!\n\n" +
                    "Type or use the 🎤 microphone to ask me anything!"
        )
    }

    private fun setupQuickPrompts() {
        val chips = listOf(
            binding.chip1, binding.chip2, binding.chip3, binding.chip4, binding.chip5
        )
        chips.forEachIndexed { index, chip ->
            chip.text = AppData.quickPrompts[index]
            chip.setOnClickListener {
                sendMessage(AppData.quickPromptFull[index])
            }
        }
    }

    private fun setupButtons() {
        binding.btnSend.setOnClickListener {
            val text = binding.etChat.text.toString().trim()
            if (text.isNotEmpty()) sendMessage(text)
        }
        binding.etChat.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                val text = binding.etChat.text.toString().trim()
                if (text.isNotEmpty()) sendMessage(text)
                true
            } else false
        }
        binding.btnMic.setOnClickListener { toggleVoice() }
    }

    private fun sendMessage(text: String) {
        binding.etChat.setText("")
        addUserMessage(text)
        showTyping()

        lifecycleScope.launch {
            try {
                val reply = callGeminiApi(text)
                hideTyping()
                addBotMessage(reply)
                speak(reply.take(300))
            } catch (e: Exception) {
                hideTyping()
                addBotMessage(
                    "🌐 I'm having trouble connecting right now. " +
                            "Here's a quick fact: Channapatna toys are made from Hale wood " +
                            "(Wrightia tinctoria) colored with natural lac resin — " +
                            "completely non-toxic and eco-friendly! Please try again shortly."
                )
            }
        }
    }

    private suspend fun callGeminiApi(userText: String): String = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        val url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=$apiKey"

        val systemPrompt = AppData.NAMMABOT_SYSTEM_PROMPT
        val fullPrompt = "$systemPrompt\n\nUser: $userText"

        val jsonBody = JSONObject().apply {
            put("contents", JSONArray().apply {
                put(JSONObject().apply {
                    put("parts", JSONArray().apply {
                        put(JSONObject().apply {
                            put("text", fullPrompt)
                        })
                    })
                })
            })
        }

        val request = Request.Builder()
            .url(url)
            .post(jsonBody.toString().toRequestBody("application/json".toMediaType()))
            .build()

        val response = httpClient.newCall(request).execute()
        val responseBody = response.body?.string() ?: throw Exception("Empty response")

        val json = JSONObject(responseBody)
        json.getJSONArray("candidates")
            .getJSONObject(0)
            .getJSONObject("content")
            .getJSONArray("parts")
            .getJSONObject(0)
            .getString("text")
    }

    private fun addUserMessage(text: String) {
        messages.add(ChatMessage(text, isBot = false, timestamp = now()))
        chatAdapter.notifyItemInserted(messages.lastIndex)
        binding.rvChat.scrollToPosition(messages.lastIndex)
    }

    private fun addBotMessage(text: String) {
        messages.add(ChatMessage(text, isBot = true, timestamp = now()))
        chatAdapter.notifyItemInserted(messages.lastIndex)
        binding.rvChat.scrollToPosition(messages.lastIndex)
    }

    private fun showTyping() { binding.layoutTyping.visibility = View.VISIBLE }
    private fun hideTyping() { binding.layoutTyping.visibility = View.GONE }
    private fun now() = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())

    // ─── TTS ───────────────────────────────────────────────────────────────
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale.US
            isTtsReady = true
        }
    }

    private fun speak(text: String) {
        val clean = text.replace(Regex("<[^>]*>"), "").replace("**", "")
        if (isTtsReady) tts.speak(clean, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    // ─── Voice ─────────────────────────────────────────────────────────────
    private fun toggleVoice() {
        if (isListening) stopListening() else startListening()
    }

    private fun startListening() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.RECORD_AUDIO)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(Manifest.permission.RECORD_AUDIO), 102
            )
            return
        }
        isListening = true
        binding.btnMic.text = "⏹"
        binding.tvVoiceStatus.visibility = View.VISIBLE
        binding.tvVoiceStatus.text = "🎤 Listening... speak now"

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireContext())
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-IN")
            putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
        }
        speechRecognizer?.setRecognitionListener(object : RecognitionListener {
            override fun onPartialResults(results: Bundle?) {
                val partial = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)?.firstOrNull() ?: ""
                binding.etChat.setText(partial)
            }
            override fun onResults(results: Bundle?) {
                val spoken = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)?.firstOrNull() ?: ""
                stopListening()
                if (spoken.isNotEmpty()) {
                    binding.etChat.setText(spoken)
                    sendMessage(spoken)
                }
            }
            override fun onError(error: Int) {
                stopListening()
                addBotMessage("I couldn't hear that clearly. Please try again or type your question!")
            }
            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() { stopListening() }
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })
        speechRecognizer?.startListening(intent)
    }

    private fun stopListening() {
        isListening = false
        binding.btnMic.text = "🎤"
        binding.tvVoiceStatus.visibility = View.GONE
        try { speechRecognizer?.cancel() } catch (_: Exception) {}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tts.shutdown()
        speechRecognizer?.destroy()
        _binding = null
    }
}
