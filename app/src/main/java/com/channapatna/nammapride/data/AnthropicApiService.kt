package com.channapatna.nammapride.data

import com.channapatna.nammapride.model.AnthropicRequest
import com.channapatna.nammapride.model.AnthropicResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AnthropicApiService {

    @Headers(
        "Content-Type: application/json",
        "anthropic-version: 2023-06-01"
    )
    @POST("v1/messages")
    suspend fun sendMessage(
        @Body request: AnthropicRequest
    ): AnthropicResponse
}
