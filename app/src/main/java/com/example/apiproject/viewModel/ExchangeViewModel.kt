package com.example.apiproject.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.apiproject.classes.Crypto
import com.example.apiproject.classes.ExchangeRateResponse
import com.example.apiproject.service.RetrofitClient

class ExchangeViewModel : ViewModel() {

    private val _exchangeResponse = mutableStateOf(ExchangeState())
    val exchangeResponse = this._exchangeResponse
    private val retrofitClient : RetrofitClient = RetrofitClient



    data class ExchangeState(
        val loading: Boolean = true,
        val exchangeResponse: ExchangeRateResponse = ExchangeRateResponse(),
        val error: String? = null
    )
}