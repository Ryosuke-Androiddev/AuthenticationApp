package com.example.authentication.presentation.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.authentication.domain.model.MessageBarState
import com.example.authentication.presentation.login.component.LoginContent
import com.example.authentication.presentation.login.component.LoginTopBar

@Composable
fun LoginScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            LoginTopBar()
        },
        content = {
            LoginContent(signedState = false, messageBarState = MessageBarState(), onClick = {})
        }
    )
}