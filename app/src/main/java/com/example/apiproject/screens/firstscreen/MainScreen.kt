package com.example.apiproject.screens.firstscreen

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


@Composable
fun MainScreen(
    navigationToFirstScreen: () -> Unit,
    navigationToSecondScreen:()->Unit,
    modifier: Modifier = Modifier
) {
    val geoLocationViewModel: GeoLocationViewModel = viewModel()

    val geoLocationViewState by geoLocationViewModel.geoLocationResponse

    val cryptoViewModel: CryptoViewModel = viewModel()

    val cryptoViewState by cryptoViewModel.cryptoResponse

    Box(modifier = Modifier.fillMaxSize().background(Color(android.graphics.Color.parseColor("#f8fcfc")))) {
        when {
            geoLocationViewState.loading && cryptoViewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            geoLocationViewState.error != null || cryptoViewState.error != null -> {
                Text("Error Occurred \n ${geoLocationViewState.error.toString()}\n ${cryptoViewState.error}  \n")
            }

            else -> {
                UserScreen(
                    geoLocationViewState.geoLocationResponse,
                    cryptoViewState.cryptoResponse,
                    { navigationToFirstScreen() },
                    { navigationToSecondScreen() }
                )
            }
        }
    }
}