package com.example.apiproject.model


data class ConversationResponse(
    val result: String = "",
    val base_code: String = "",
    val target_code: String = "",
    val conversion_result: Double = 0.0,
)