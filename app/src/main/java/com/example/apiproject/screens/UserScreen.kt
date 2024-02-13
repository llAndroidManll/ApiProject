package com.example.apiproject.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.apiproject.classes.Crypto
import com.example.apiproject.classes.ExchangeRateResponse
import com.example.apiproject.classes.GeoLocationResponse
import com.example.apiproject.classes.UserInfo

@Composable
fun UserScreen(
    geoLocationResponse: GeoLocationResponse,
    userInfo: UserInfo,
    listCrypto: List<Crypto>,
    exchangeResponse: ExchangeRateResponse
) {
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp,10.dp,20.dp),
        ) {
            TopRankedCrypto(listCrypto)
            Spacer(modifier = Modifier.height(10.dp))
            CryptoSection(listCrypto)
        }
        BottomNavigationBar()
    }
}