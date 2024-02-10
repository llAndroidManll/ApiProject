package com.example.apiproject.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiproject.classes.Currency
import com.example.apiproject.classes.GeoLocationResponse
import com.example.apiproject.service.RetrofitClient
import kotlinx.coroutines.launch

class GeoLocationViewModel: ViewModel() {

    private val _geoLocationResponse = mutableStateOf(RecipeGeoLocationState())
    val geoLocationResponse = this._geoLocationResponse
    private val retrofitClient : RetrofitClient = RetrofitClient


    init {
        fetchGeoLocation()
    }


    private fun fetchGeoLocation() {
        viewModelScope.launch {
            try {
                val response = retrofitClient.geoLocationService.getGeoLocation("3607b318d75d4f45bb8df45c5bcfa286")
                _geoLocationResponse.value =  _geoLocationResponse.value.copy(
                    geoLocationResponse = response,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _geoLocationResponse.value = _geoLocationResponse.value.copy(
                    loading = false,
                    error = "Error fetching GeoLocation: ${e.message}"
                )
                Log.e("Fetch Errors", "Error fetching GeoLocation: ${e.message}")
            }
        }
    }

    data class RecipeGeoLocationState(
        val loading: Boolean = true,
        val geoLocationResponse: GeoLocationResponse = GeoLocationResponse(Currency("","",""),""),
        val error: String? = null
    )

}
