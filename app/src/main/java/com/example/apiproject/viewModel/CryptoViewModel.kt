package com.example.apiproject.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiproject.model.Crypto
import com.example.apiproject.service.RetrofitClient
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {
    private val _cryptoResponse = mutableStateOf(CryptoState())
    val cryptoResponse = this._cryptoResponse
    private val retrofitClient : RetrofitClient = RetrofitClient


    init {
        fetchCrypto()
    }


    private fun fetchCrypto() {
        viewModelScope.launch {
            try {
                val response = retrofitClient.cryptoService.getCrypto()

                _cryptoResponse.value =  _cryptoResponse.value.copy(
                    cryptoResponse = response,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _cryptoResponse.value = _cryptoResponse.value.copy(
                    loading = false,
                    error = "Error fetching Crypto: ${e.message}"
                )
                Log.e("Fetch Errors", "Error fetching Crypto: ${e.message}")
                Log.e("Fetch Errors", "${e.cause}")
            }
        }
    }

    data class CryptoState(
        val loading: Boolean = true,
        val cryptoResponse: List<Crypto> = emptyList<Crypto>(),
        val error: String? = null
    )
}