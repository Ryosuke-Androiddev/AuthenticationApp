package com.example.authentication.presentation.login.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.example.authentication.ui.theme.topAppBarBackgroundColor
import com.example.authentication.ui.theme.topAppBarContentColor

@Composable
fun LoginTopBar() {

    TopAppBar(
        title = {
            Text(
                text = "Sign in",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}