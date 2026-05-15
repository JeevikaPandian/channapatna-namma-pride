package com.channapatna.nammapride.ui.ai;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\n !*\u0004\u0018\u00010\u001a0\u001aH\u0002J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u0018H\u0016J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0016J\u001a\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u00100\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u00101\u001a\u00020\u0018H\u0002J\b\u00102\u001a\u00020\u0018H\u0002J\b\u00103\u001a\u00020\u0018H\u0002J\b\u00104\u001a\u00020\u0018H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u0018H\u0002J\b\u00107\u001a\u00020\u0018H\u0002J\b\u00108\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/channapatna/nammapride/ui/ai/AiFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "()V", "_binding", "Lcom/channapatna/nammapride/databinding/FragmentAiBinding;", "binding", "getBinding", "()Lcom/channapatna/nammapride/databinding/FragmentAiBinding;", "chatAdapter", "Lcom/channapatna/nammapride/ui/ai/ChatAdapter;", "httpClient", "Lokhttp3/OkHttpClient;", "isListening", "", "isTtsReady", "messages", "", "Lcom/channapatna/nammapride/model/ChatMessage;", "speechRecognizer", "Landroid/speech/SpeechRecognizer;", "tts", "Landroid/speech/tts/TextToSpeech;", "addBotMessage", "", "text", "", "addUserMessage", "callGeminiApi", "userText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideTyping", "now", "kotlin.jvm.PlatformType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onInit", "status", "", "onViewCreated", "view", "sendMessage", "setupButtons", "setupChat", "setupQuickPrompts", "showTyping", "speak", "startListening", "stopListening", "toggleVoice", "app_debug"})
public final class AiFragment extends androidx.fragment.app.Fragment implements android.speech.tts.TextToSpeech.OnInitListener {
    @org.jetbrains.annotations.Nullable()
    private com.channapatna.nammapride.databinding.FragmentAiBinding _binding;
    private android.speech.tts.TextToSpeech tts;
    private boolean isTtsReady = false;
    @org.jetbrains.annotations.Nullable()
    private android.speech.SpeechRecognizer speechRecognizer;
    private boolean isListening = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.channapatna.nammapride.model.ChatMessage> messages = null;
    private com.channapatna.nammapride.ui.ai.ChatAdapter chatAdapter;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient httpClient = null;
    
    public AiFragment() {
        super();
    }
    
    private final com.channapatna.nammapride.databinding.FragmentAiBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupChat() {
    }
    
    private final void setupQuickPrompts() {
    }
    
    private final void setupButtons() {
    }
    
    private final void sendMessage(java.lang.String text) {
    }
    
    private final java.lang.Object callGeminiApi(java.lang.String userText, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final void addUserMessage(java.lang.String text) {
    }
    
    private final void addBotMessage(java.lang.String text) {
    }
    
    private final void showTyping() {
    }
    
    private final void hideTyping() {
    }
    
    private final java.lang.String now() {
        return null;
    }
    
    @java.lang.Override()
    public void onInit(int status) {
    }
    
    private final void speak(java.lang.String text) {
    }
    
    private final void toggleVoice() {
    }
    
    private final void startListening() {
    }
    
    private final void stopListening() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}