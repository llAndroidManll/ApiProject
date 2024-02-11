package com.example.apiproject.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.apiproject.R

@Composable
fun Header(
    countryName: String,
    city: String,
    locality: String,
    currency: String,
    countryFlag: String,
    symbol: String,
) {

    val textStyle = TextStyle(
        color = Color.White,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Light,
        lineHeight = 23.sp,
        fontSize = 17.sp,
        letterSpacing = 0.sp
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(171.dp)
            .paint(
                painterResource(id = R.drawable.background_image),
                contentScale = ContentScale.FillBounds
            )
    ) {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 40.dp)
        ) {
            Text(
                text =  "Your current location ` \n   $countryName($city), $locality",
                style = textStyle,
                modifier = Modifier.zIndex(1F)
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            Text(
                text = "Your currency ` $currency, $symbol",
                style = textStyle,
                modifier = Modifier.zIndex(1F)
            )

        }
    }
}