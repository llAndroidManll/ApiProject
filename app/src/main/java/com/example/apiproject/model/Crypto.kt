package com.example.apiproject.model

data class Crypto (
    val name: String,
    val image: String,
    val current_price: Double,
    val market_cap_rank: Int,
    val last_updated: String,
    val price_change_percentage_24h: Double
)
data class CryptoResponse (
    val crypto: List<Crypto>
)