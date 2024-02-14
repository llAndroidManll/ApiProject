package com.example.apiproject.screens.secondscreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Conversation() {
    Row (
      modifier = Modifier
          .fillMaxWidth()
          .border(1.dp, Color.Red)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth().border(1.dp, Color.Blue),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}