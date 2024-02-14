package com.example.apiproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.apiproject.R

@Composable
fun BottomNavigationBar(
    navigationToFirstScreen: () -> Unit,
    navigationToSecondScreen:()->Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            onClick = {
                navigationToFirstScreen()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent ,contentColor = Color.Transparent,),
            modifier = Modifier
                .border(
                    1.dp,
                    Color(0xFFE4E4E4),
                    RoundedCornerShape(20)
                )
                .size(60.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Home Button",
                modifier = Modifier
                    .size(16.dp)
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Button(
            onClick = {
                navigationToSecondScreen()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent ,contentColor = Color.Transparent,),
            modifier = Modifier
                .border(
                    1.dp,
                    Color(0xFFE4E4E4),
                    RoundedCornerShape(20)
                )
                .size(60.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.usd),
                contentDescription = "Button Image",
                modifier = Modifier
                    .size(16.dp)

            )
        }
    }
}