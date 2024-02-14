package com.example.apiproject.screens.secondscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apiproject.model.ConversationResponse
import com.example.apiproject.model.ExchangeRateResponse
import com.example.apiproject.screens.BottomNavigationBar
import com.example.apiproject.screens.Header

@Composable
fun SecondUserScreen(
    exchangeResponse: ExchangeRateResponse,
    conversationResponse: ConversationResponse,
    navigationToFirstScreen: () -> Unit,
    navigationToSecondScreen: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Header("Conversation", 30.dp)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp,10.dp,20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Conversation()
            BottomNavigationBar(
                { navigationToFirstScreen() },
                { navigationToSecondScreen() }
            )
        }
    }
}