package com.example.apiproject.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiproject.service.RetrofitClient
import com.example.apiproject.classes.UserInfo
import kotlinx.coroutines.launch

class UserInfoViewModel: ViewModel(){
    private val _userInfoResponse = mutableStateOf(RecipeUserInfoState())
    val userInfoResponse = this._userInfoResponse
    private val retrofitClient : RetrofitClient = RetrofitClient


    init {
        fetchUserInfo()
    }


    private fun fetchUserInfo() {
        viewModelScope.launch {
            try {
                val response = retrofitClient.userInfoService.getUserInfo()
                _userInfoResponse.value =  _userInfoResponse.value.copy(
                    userInfo = response,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _userInfoResponse.value = _userInfoResponse.value.copy(
                    loading = false,
                    error = "Error fetching UserInfo: ${e.message}",
                )
                Log.e("Fetch Errors", "Error fetching UserInfo: ${e.message}")
            }
        }
    }

    data class RecipeUserInfoState(
        val loading: Boolean = true,
        val userInfo: UserInfo = UserInfo(),
        val error: String? = null
    )
}