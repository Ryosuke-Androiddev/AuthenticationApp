package com.example.authentication.presentation.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.authentication.domain.model.MessageBarState
import com.example.authentication.presentation.login.component.LoginContent
import com.example.authentication.presentation.login.component.LoginTopBar

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = hiltViewModel()
) {

    val signedInState by viewModel.signedInState
    val messageBarState by viewModel.messageBarState

    Scaffold(
        topBar = {
            LoginTopBar()
        },
        content = {
            LoginContent(
                signedState = signedInState,
                messageBarState = messageBarState,
                onClick = {
                    viewModel.saveSignedInState(signedInState = true)
                }
            )
        }
    )
}