package com.example.apiproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apiproject.viewModel.CryptoViewModel
import com.example.apiproject.viewModel.ExchangeViewModel
import com.example.apiproject.viewModel.GeoLocationViewModel
import com.example.apiproject.viewModel.UserInfoViewModel


@Composable
fun RecipeScreen(modifier: Modifier = Modifier) {
    val geoLocationViewModel: GeoLocationViewModel = viewModel()

    val geoLocationViewState by geoLocationViewModel.geoLocationResponse

    val userInfoViewModel: UserInfoViewModel = viewModel()

    val userInfoViewState by userInfoViewModel.userInfoResponse

    val cryptoViewModel: CryptoViewModel = viewModel()

    val cryptoViewState by cryptoViewModel.cryptoResponse

    val exchangeViewModel: ExchangeViewModel = viewModel()

    val exchangeViewState by exchangeViewModel.exchangeResponse

    Box(modifier = Modifier.fillMaxSize().background(Color(android.graphics.Color.parseColor("#f8fcfc")))) {
        when {
            geoLocationViewState.loading && userInfoViewState.loading && cryptoViewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            geoLocationViewState.error != null || userInfoViewState.error != null || cryptoViewState.error != null || exchangeViewState.error != null-> {
                Text("Error Occurred \n ${geoLocationViewState.error.toString()} \n ${userInfoViewState.error.toString()} \n ${cryptoViewState.error}  \n" +
                        " ${exchangeViewState.error}")
            }

            else -> {
                UserScreen(geoLocationViewState.geoLocationResponse, userInfoViewState.userInfo, cryptoViewState.cryptoResponse, exchangeViewState.exchangeResponse)
            }
        }
    }
}