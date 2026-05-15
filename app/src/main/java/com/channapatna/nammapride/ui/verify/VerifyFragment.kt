package com.channapatna.nammapride.ui.verify

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.channapatna.nammapride.data.ToyRepository
import com.channapatna.nammapride.databinding.FragmentVerifyBinding
import com.channapatna.nammapride.model.ToyVerification
import kotlinx.coroutines.launch
import java.util.Locale

class VerifyFragment : Fragment(), TextToSpeech.OnInitListener {

    private var _binding: FragmentVerifyBinding? = null
    private val binding get() = _binding!!

    private lateinit var tts: TextToSpeech
    private var isTtsReady = false
    private var speechRecognizer: SpeechRecognizer? = null
    private val repository = ToyRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerifyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tts = TextToSpeech(requireContext(), this)

        binding.btnVerify.setOnClickListener { verifyToy() }
        binding.btnVoiceVerify.setOnClickListener { startVoiceVerify() }

        binding.btnDemo1.setOnClickListener {
            binding.etToyId.setText("423781")
            verifyToy()
        }
        binding.btnDemo2.setOnClickListener {
            binding.etToyId.setText("195023")
            verifyToy()
        }
        binding.btnDemo3.setOnClickListener {
            binding.etToyId.setText("777001")
            verifyToy()
        }
        binding.btnDemoFake.setOnClickListener {
            binding.etToyId.setText("999999")
            verifyToy()
        }
    }

    private fun verifyToy() {
        val id = binding.etToyId.text.toString().trim()
        if (id.length != 6) {
            showError("Please enter a valid 6-digit Toy ID")
            return
        }

        showLoading()

        // Simulate network delay then check
        Handler(Looper.getMainLooper()).postDelayed({
            lifecycleScope.launch {
                val result = repository.verifyToy(id)
                result.fold(
                    onSuccess = { toy ->
                        if (toy != null) {
                            showVerified(toy)
                            speak(
                                "Verification successful! This toy was crafted by ${toy.artisan} " +
                                "from ${toy.village}, with ${toy.years} years of expertise. " +
                                "The toy is a ${toy.toy}, made using ${toy.lac}. " +
                                "This is a GI certified authentic Channapatna toy."
                            )
                        } else {
                            showNotFound()
                            speak(
                                "Warning! This Toy ID is not recognized. " +
                                "This may be a counterfeit Channapatna toy. " +
                                "Please contact the GI authority."
                            )
                        }
                    },
                    onFailure = { showError("Network error. Please try again.") }
                )
            }
        }, 1200)
    }

    private fun showLoading() {
        binding.layoutResult.visibility = View.VISIBLE
        binding.layoutVerified.visibility = View.GONE
        binding.layoutNotFound.visibility = View.GONE
        binding.layoutLoading.visibility = View.VISIBLE
    }

    private fun showVerified(toy: ToyVerification) {
        binding.layoutLoading.visibility = View.GONE
        binding.layoutVerified.visibility = View.VISIBLE
        binding.layoutNotFound.visibility = View.GONE

        binding.tvArtisanAvatar.text = toy.avatar
        binding.tvArtisanName.text = toy.artisan
        binding.tvArtisanDetails.text = "📍 ${toy.village} · ${toy.years} years"
        binding.tvToyName.text = toy.toy
        binding.tvLacType.text = toy.lac
        binding.tvBatch.text = toy.batch
        binding.tvSpecialty.text = toy.specialty

        binding.btnHearStory.setOnClickListener {
            speak(
                "This beautiful ${toy.toy} was lovingly crafted by ${toy.artisan} " +
                "from ${toy.village}. Each piece represents generations of skill, " +
                "shaped on a hand-operated lathe and colored with natural lac " +
                "from the forests of Karnataka. When you hold this toy, " +
                "you are holding living heritage."
            )
        }
    }

    private fun showNotFound() {
        binding.layoutLoading.visibility = View.GONE
        binding.layoutVerified.visibility = View.GONE
        binding.layoutNotFound.visibility = View.VISIBLE
    }

    private fun showError(msg: String) {
        binding.layoutResult.visibility = View.GONE
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    // ─── Text-to-Speech ────────────────────────────────────────────────────

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale.US
            isTtsReady = true
        }
    }

    private fun speak(text: String) {
        if (isTtsReady) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    // ─── Voice recognition ─────────────────────────────────────────────────

    private fun startVoiceVerify() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.RECORD_AUDIO)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(Manifest.permission.RECORD_AUDIO), 101
            )
            return
        }

        binding.tvVoiceStatus.visibility = View.VISIBLE
        binding.tvVoiceStatus.text = "🎤 Listening for Toy ID..."

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireContext())
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-IN")
        }

        speechRecognizer?.setRecognitionListener(object : RecognitionListener {
            override fun onResults(results: Bundle?) {
                val spoken = results
                    ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.firstOrNull()
                    ?.replace(Regex("\\D"), "")
                    ?.take(6) ?: ""

                if (spoken.isNotEmpty()) {
                    binding.etToyId.setText(spoken)
                    binding.tvVoiceStatus.text = "Heard: \"$spoken\""
                    Handler(Looper.getMainLooper()).postDelayed({
                        binding.tvVoiceStatus.visibility = View.GONE
                        verifyToy()
                    }, 800)
                } else {
                    binding.tvVoiceStatus.visibility = View.GONE
                }
            }

            override fun onError(error: Int) {
                binding.tvVoiceStatus.visibility = View.GONE
                Toast.makeText(requireContext(), "Could not hear. Please try again.", Toast.LENGTH_SHORT).show()
            }

            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })

        speechRecognizer?.startListening(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tts.shutdown()
        speechRecognizer?.destroy()
        _binding = null
    }
}
