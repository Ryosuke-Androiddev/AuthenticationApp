package com.example.authentication.presentation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.example.authentication.domain.model.MessageBarState
import com.example.authentication.util.NetworkConstants.CONNECTION_EXCEPTION_MESSAGE
import com.example.authentication.util.NetworkConstants.SOCKET_TIME_OUT_EXCEPTION_MESSAGE
import kotlinx.coroutines.delay
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun MessageBar(messageBarState: MessageBarState) {

    var startAnimation by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(key1 = messageBarState) {
        if (messageBarState.error != null) {
            errorMessage = when (messageBarState.error) {
                is SocketTimeoutException -> {
                    SOCKET_TIME_OUT_EXCEPTION_MESSAGE
                }
                is ConnectException -> {
                    CONNECTION_EXCEPTION_MESSAGE
                }
                else -> {
                    "${messageBarState.error.message}"
                }
            }
        }

        startAnimation = true
        delay(300)
        startAnimation = false
    }

    AnimatedVisibility(
        visible = messageBarState.error != null && startAnimation
                || messageBarState.message != null && startAnimation,
        enter = expandVertically(
            animationSpec = tween(durationMillis = 300),
            expandFrom = Alignment.Top
        ),
        exit = shrinkVertically(
            animationSpec = tween(
                durationMillis = 300
            ),
            shrinkTowards = Alignment.Top
        )
    ) {
        // ここに直接Composableを書いてもいいんだけど、Previewするのが難しい(Stateで変化するUIだから)
        // よって、別Composableをここに呼び出し、別でPreviewする
        MessageBar(messageBarState = messageBarState)
    }
}