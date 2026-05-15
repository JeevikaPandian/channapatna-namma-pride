package com.channapatna.nammapride.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/channapatna/nammapride/data/AnthropicApiService;", "", "sendMessage", "Lcom/channapatna/nammapride/model/AnthropicResponse;", "request", "Lcom/channapatna/nammapride/model/AnthropicRequest;", "(Lcom/channapatna/nammapride/model/AnthropicRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AnthropicApiService {
    
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "anthropic-version: 2023-06-01"})
    @retrofit2.http.POST(value = "v1/messages")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendMessage(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.channapatna.nammapride.model.AnthropicRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.channapatna.nammapride.model.AnthropicResponse> $completion);
}