package com.example.apiproject.screens.secondscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apiproject.viewModel.ConversationViewModel
import com.example.apiproject.viewModel.ExchangeViewModel


@Composable
fun SecondScreen(
    navigationToFirstScreen: () -> Unit,
    navigationToSecondScreen:()->Unit,
    modifier: Modifier = Modifier
) {
    val exchangeViewModel: ExchangeViewModel = viewModel()
    val exchangeViewState by  exchangeViewModel.exchangeResponse
    
    val conversationViewModel: ConversationViewModel = viewModel()
    val conversationViewState by  conversationViewModel.conversationResponse

    Box(modifier = Modifier.fillMaxSize().background(Color(android.graphics.Color.parseColor("#f8fcfc")))) {
        when {
            exchangeViewState.loading && conversationViewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            exchangeViewState.error != null || conversationViewState.error != null -> {
                Text("Error Occurred \n ${exchangeViewState.error.toString()}\n ${conversationViewState.error}  \n")
            }
            else -> {
                SecondUserScreen(
                    exchangeViewState.exchangeResponse,
                    conversationViewState.conversationResponse,
                    { navigationToFirstScreen() },
                    { navigationToSecondScreen() }
                )
            }
        }
    }
}