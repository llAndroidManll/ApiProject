package com.example.apiproject.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.apiproject.classes.GeoLocationResponse
import com.example.apiproject.R
import com.example.apiproject.classes.Crypto
import com.example.apiproject.classes.UserInfo
import com.example.apiproject.viewModel.CryptoViewModel
import com.example.apiproject.viewModel.GeoLocationViewModel
import com.example.apiproject.viewModel.UserInfoViewModel
import org.w3c.dom.Text


@Composable
fun RecipeScreen(modifier: Modifier = Modifier) {
    val geoLocationViewModel: GeoLocationViewModel = viewModel()

    val geoLocationViewState by geoLocationViewModel.geoLocationResponse

    val userInfoViewModel: UserInfoViewModel = viewModel()

    val userInfoViewState by userInfoViewModel.userInfoResponse

    val cryptoViewModel: CryptoViewModel = viewModel()

    val cryptoViewState by cryptoViewModel.cryptoResponse

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            geoLocationViewState.loading && userInfoViewState.loading && cryptoViewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            geoLocationViewState.error != null || userInfoViewState.error != null || cryptoViewState.error != null-> {
                Text("Error Occurred \n ${geoLocationViewState.error.toString()} \n ${userInfoViewState.error.toString()} \n ${cryptoViewState.error}")
            }

            else -> {
                UserScreen(geoLocationViewState.geoLocationResponse, userInfoViewState.userInfo, cryptoViewState.cryptoResponse)
            }
        }
    }
}
@Composable
fun UserScreen(geoLocationResponse: GeoLocationResponse, userInfo: UserInfo, listCrypto: List<Crypto>) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Header(
            userInfo.countryName,
            userInfo.city,
            userInfo.locality,
            geoLocationResponse.currency.code,
            geoLocationResponse.country_flag,
            geoLocationResponse.currency.symbol
        )
        CryptoSection(listCrypto)
    }
}

@Composable
fun CryptoSection(listCrypto: List<Crypto>,modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
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
            .size(142.dp,134.dp)
            .padding(10.dp, 15.dp,5.dp,10.dp)
            .border(1.dp,Color(0xFFF2F2F2), RoundedCornerShape(15))
        ,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(model = cryptoBlock.image, contentDescription = null , modifier = Modifier.aspectRatio(1f).size(27.dp,27.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(cryptoBlock.name)
            Text(cryptoBlock.current_price.toString())
        }
        PriceChange(cryptoBlock.price_change_percentage_24h,textStyle)
    }
}
@Composable
fun PriceChange(price : Double, textStyle: TextStyle) {
    return if (price>0) {
        Text(text = "+$price%",style = textStyle, color = Color.Green)
    } else if (price<0) {
        Text(text = "-$price%",style = textStyle, color = Color.Red)
    } else {
        Text(text = "0",style = textStyle, color = Color.Black)
    }
}

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