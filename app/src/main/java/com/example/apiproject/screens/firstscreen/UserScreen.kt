package com.example.apiproject.screens.firstscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apiproject.model.Crypto
import com.example.apiproject.model.ExchangeRateResponse
import com.example.apiproject.model.GeoLocationResponse
import com.example.apiproject.screens.BottomNavigationBar
import com.example.apiproject.screens.Header

@Composable
fun UserScreen(
    geoLocationResponse: GeoLocationResponse,
    listCrypto: List<Crypto>,
    exchangeResponse: ExchangeRateResponse,
    navigationToFirstScreen: () -> Unit,
    navigationToSecondScreen:()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Header("Crypto Main Screen", 50.dp)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp,10.dp,20.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            TopRankedCrypto(listCrypto)
            CryptoSection(listCrypto)
            BottomNavigationBar(
                { navigationToFirstScreen() },
                { navigationToSecondScreen() }
            )
        }
    }
}
