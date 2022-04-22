package com.example.authentication.presentation.navigation

import com.example.authentication.presentation.navigation.Constants.LOGIN_SCREEN_ROUTE
import com.example.authentication.presentation.navigation.Constants.PROFILE_SCREEN_ROUTE

sealed class Screen(val route: String) {

    object Login: Screen(LOGIN_SCREEN_ROUTE)
    object Profile: Screen(PROFILE_SCREEN_ROUTE)
}
