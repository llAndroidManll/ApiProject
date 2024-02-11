package com.example.apiproject.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.apiproject.classes.Crypto

@Composable
fun CryptoSection(listCrypto: List<Crypto>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(listCrypto) { crypto ->
            CryptoSectionItem(crypto)
        }
    }
}


@Composable
fun CryptoSectionItem(cryptoBlock: Crypto) {

    val textStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Light,
        lineHeight = 23.sp,
        fontSize = 17.sp,
        letterSpacing = 0.sp
    )
    Column(
        modifier = Modifier
            .size(142.dp, 134.dp)
            .border(1.dp, Color(0xFFF2F2F2), RoundedCornerShape(5))
            .absolutePadding(10.dp, 20.dp, 5.dp, 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        AsyncImage(
            model = cryptoBlock.image,
            contentDescription = null,
            modifier = Modifier.size(27.dp, 27.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = cryptoBlock.name,
                maxLines = 1, // Limiting the number of lines to 1
                overflow = TextOverflow.Ellipsis,// Setting overflow to Ellipsis
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.width(63.5.dp)
            )
            Text(
                "${cryptoBlock.current_price} ${'$'}",
                maxLines = 1, // Limiting the number of lines to 1
                overflow = TextOverflow.Ellipsis,// Setting overflow to Ellipsis
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Color(0xFF878787)
                ),
            )
        }
        PriceChange(cryptoBlock.price_change_percentage_24h, textStyle)
    }
}

@Composable
fun PriceChange(price: Double, textStyle: TextStyle, modifier: Modifier = Modifier) {
    return if (price > 0) {
        Text(text = "+$price%", style = textStyle, color = Color.Green, modifier = modifier)
    } else if (price < 0) {
        Text(text = "-$price%", style = textStyle, color = Color.Red, modifier = modifier)
    } else {
        Text(text = "0", style = textStyle, color = Color.Black, modifier = modifier)
    }
}

