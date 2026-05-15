package com.channapatna.nammapride.model

// ─── Toy Verification ──────────────────────────────────────────────────────

data class ToyVerification(
    val artisan: String = "",
    val avatar: String = "",
    val village: String = "",
    val years: Int = 0,
    val specialty: String = "",
    val toy: String = "",
    val lac: String = "",
    val batch: String = "",
    val status: String = ""
)

// ─── Toy Catalogue ─────────────────────────────────────────────────────────

data class Toy(
    val name: String,
    val artisan: String,
    val price: String,
    val category: String,
    val emoji: String,
    val bgColor: String,
    val isGICertified: Boolean
)

enum class ToyCategory(val label: String) {
    ALL("All Toys"),
    TOPS("Tops"),
    HORSES("Horses"),
    DOLLS("Dolls"),
    ANIMALS("Animals"),
    PUZZLES("Puzzles")
}

// ─── Artisan ───────────────────────────────────────────────────────────────

data class Artisan(
    val name: String,
    val emoji: String,
    val specialty: String,
    val rating: Double
)

// ─── Workshop ──────────────────────────────────────────────────────────────

data class Workshop(
    val name: String,
    val address: String,
    val hours: String,
    val emoji: String,
    val latitude: Double,
    val longitude: Double
)

// ─── Chat ──────────────────────────────────────────────────────────────────

data class ChatMessage(
    val text: String,
    val isBot: Boolean,
    val timestamp: String = ""
)

// ─── Anthropic API ────────────────────────────────────────────────────────

data class AnthropicRequest(
    val model: String,
    val max_tokens: Int,
    val system: String,
    val messages: List<AnthropicMessage>
)

data class AnthropicMessage(
    val role: String,
    val content: String
)

data class AnthropicResponse(
    val content: List<AnthropicContent>
)

data class AnthropicContent(
    val type: String,
    val text: String
)

// ─── Process Steps ─────────────────────────────────────────────────────────

data class ProcessStep(
    val stepNumber: Int,
    val title: String,
    val description: String,
    val colorStart: String,
    val colorEnd: String
)
