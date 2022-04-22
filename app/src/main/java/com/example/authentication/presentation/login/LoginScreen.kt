package com.example.authentication.presentation.login

import android.app.Activity
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.authentication.domain.model.MessageBarState
import com.example.authentication.presentation.login.component.LoginContent
import com.example.authentication.presentation.login.component.LoginTopBar
import com.example.authentication.presentation.util.StartActivityForResult
import com.example.authentication.presentation.util.signIn

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

    val activity = LocalContext.current as Activity

    StartActivityForResult(
        key = signedInState,
        onResultReceived = { tokenId ->
            Log.d("LoginScreen", tokenId)
        },
        onDialogDismissed = {
            viewModel.saveSignedInState(signedInState = false)
        }
    ) { activityLauncher ->
        if (signedInState) {
            signIn(
                activity = activity,
                launchActivityResult = { intentSenderRequest ->
                    activityLauncher.launch(intentSenderRequest)
                },
                accountNotFound = {
                    viewModel.saveSignedInState(signedInState = false)
                    viewModel.updateMessageBarState()
                }
            )
        }
    }
}