package com.example.apiproject.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.apiproject.classes.Crypto

@Composable
fun TopRankedCrypto(listCrypto: List<Crypto>) {
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .height(455.dp)
    ) {
        items(listCrypto.filter { it.market_cap_rank <= 10 }) { crypto ->
            TopRankedCryptoItem(crypto)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun TopRankedCryptoItem(cryptoBlock: Crypto) {
    val textStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Light,
        lineHeight = 23.sp,
        fontSize = 13.sp,
        letterSpacing = 0.sp
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(67.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row (
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 10.dp)
            ) {
                AsyncImage(
                    model = cryptoBlock.image,
                    contentDescription = null,
                    modifier = Modifier.size(27.dp, 27.dp)
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = cryptoBlock.name,
                    maxLines = 1, // Limiting the number of lines to 1
                    overflow = TextOverflow.Ellipsis,// Setting overflow to Ellipsis
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.width(63.5.dp)
                )
                PriceChange(
                    cryptoBlock.price_change_percentage_24h,
                    textStyle,
                )
            }
        }


        Text(
            text = "Rank ${cryptoBlock.market_cap_rank}",
            style = TextStyle(
                fontSize = 13.sp,
                color = Color.Black
            ),
            textAlign = TextAlign.Center,
        )

        Text(
            "${cryptoBlock.current_price} ${'$'}",
            maxLines = 1, // Limiting the number of lines to 1
            overflow = TextOverflow.Ellipsis,// Setting overflow to Ellipsis
            style = TextStyle(
                fontSize = 13.sp,
                color = Color(0xFF878787)
            ),
            modifier = Modifier
                .width(70.dp),
            textAlign = TextAlign.Center,
        )
    }
}