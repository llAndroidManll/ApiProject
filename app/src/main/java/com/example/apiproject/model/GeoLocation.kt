package com.example.apiproject.model

data class GeoLocationResponse(
    val currency: Currency,
)

data class Currency(
    val code: String,
    val name: String,
    val symbol: String
)
