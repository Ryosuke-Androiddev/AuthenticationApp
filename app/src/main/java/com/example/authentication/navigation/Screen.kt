package com.example.authentication.navigation

import com.example.authentication.navigation.Constants.LOGIN_SCREEN_ROUTE
import com.example.authentication.navigation.Constants.PROFILE_SCREEN_ROUTE

sealed class Screen(val route: String) {

    object Login: Screen(LOGIN_SCREEN_ROUTE)
    object Profile: Screen(PROFILE_SCREEN_ROUTE)
}
