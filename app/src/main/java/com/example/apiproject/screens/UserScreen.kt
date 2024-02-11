package com.example.apiproject.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.apiproject.classes.Crypto
import com.example.apiproject.classes.ExchangeRateResponse
import com.example.apiproject.classes.GeoLocationResponse
import com.example.apiproject.classes.UserInfo

@Composable
fun UserScreen(geoLocationResponse: GeoLocationResponse, userInfo: UserInfo, listCrypto: List<Crypto>, exchangeResponse: ExchangeRateResponse) {
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