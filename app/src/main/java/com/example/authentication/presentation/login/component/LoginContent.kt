package com.example.authentication.presentation.login.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.authentication.domain.model.MessageBarState
import com.example.authentication.presentation.component.MessageBar

@Composable
fun LoginContent(
    signedState: Boolean,
    messageBarState: MessageBarState,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            MessageBar(messageBarState = messageBarState)
        }

        Column(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginCentralContent(signedInState = signedState, onClick = onClick)
        }
    }
}