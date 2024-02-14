package com.example.apiproject.screens.secondscreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.apiproject.screens.BottomNavigationBar


@Composable
fun SecondScreen(
    navigationToFirstScreen: () -> Unit,
    navigationToSecondScreen:()->Unit,
    modifier: Modifier = Modifier
) {

    BottomNavigationBar(
        navigationToFirstScreen = { navigationToFirstScreen() },
        navigationToSecondScreen = { navigationToSecondScreen() }
    )
}