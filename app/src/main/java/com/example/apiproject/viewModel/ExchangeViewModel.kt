package com.example.apiproject.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiproject.classes.Crypto
import com.example.apiproject.classes.ExchangeRateResponse
import com.example.apiproject.service.RetrofitClient
import kotlinx.coroutines.launch

class ExchangeViewModel : ViewModel() {

    private val _exchangeResponse = mutableStateOf(ExchangeState())
    val exchangeResponse = this._exchangeResponse
    private val retrofitClient : RetrofitClient = RetrofitClient

    init {
        fetchExchange()
    }

    private fun fetchExchange() {
        viewModelScope.launch {
            try {
                val response = retrofitClient.exchangeService.getExchangeRate()

                _exchangeResponse.value =  _exchangeResponse.value.copy(
                    loading = false,
                    exchangeResponse = response,
                    error = null
                )
            } catch (e: Exception) {
                _exchangeResponse.value = _exchangeResponse.value.copy(
                    loading = false,
                    error = "Error fetching Exchange: ${e.message}"
                )
                Log.e("Fetch Errors", "Error fetching Exchange: ${e.message}")
                Log.e("Fetch Errors", "${e.cause}")
            }
        }
    }

    data class ExchangeState(
        val loading: Boolean = true,
        val exchangeResponse: ExchangeRateResponse = ExchangeRateResponse(),
        val error: String? = null
    )
}