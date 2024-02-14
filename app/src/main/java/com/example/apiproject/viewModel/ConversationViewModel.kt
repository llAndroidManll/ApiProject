package com.example.apiproject.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiproject.model.ConversationResponse
import com.example.apiproject.model.ExchangeRateResponse
import com.example.apiproject.service.RetrofitClient
import kotlinx.coroutines.launch

class ConversationViewModel : ViewModel() {

    private val _conversationResponse = mutableStateOf(ConversationState())
    val conversationResponse = this._conversationResponse
    private val retrofitClient : RetrofitClient = RetrofitClient

    init {
        fetchConversation()
    }

    private fun fetchConversation() {
        viewModelScope.launch {
            try {
                val response = retrofitClient.conversationService
                    .getConversationResponse(
                        "",
                        "",
                        0.0
                    )

                _conversationResponse.value =  _conversationResponse.value.copy(
                    loading = false,
                    conversationResponse = response,
                    error = null
                )
            } catch (e: Exception) {
                _conversationResponse.value = _conversationResponse.value.copy(
                    loading = false,
                    error = "Error fetching Conversation: ${e.message}"
                )
                Log.e("Fetch Errors", "Error fetching Conversation: ${e.message}")
                Log.e("Fetch Errors", "${e.cause}")
            }
        }
    }

    data class ConversationState(
        val loading: Boolean = true,
        val conversationResponse: ConversationResponse = ConversationResponse(),
        val error: String? = null
    )
}