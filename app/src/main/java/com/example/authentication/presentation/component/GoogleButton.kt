package com.example.authentication.presentation.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.authentication.R
import com.example.authentication.ui.theme.LoadingBlue
import com.example.authentication.ui.theme.Shapes
import com.example.authentication.util.UIConstants.PRIMARY_TEXT
import com.example.authentication.util.UIConstants.SECONDARY_TEXT

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    loadingState: Boolean = false,
    primaryText: String = PRIMARY_TEXT,
    secondaryText: String = SECONDARY_TEXT,
    icon: Int = R.drawable.ic_google_logo,
    shape: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    backGroundColor: Color = MaterialTheme.colors.surface,
    borderStrokeWidth: Dp = 1.dp,
    progressIndicatorStrokeWidth: Dp = 3.dp,
    progressIndicatorColor: Color = LoadingBlue,
    onClick: () -> Unit
) {

    var buttonText by remember { mutableStateOf(primaryText) }

    LaunchedEffect(key1 = loadingState) {
        buttonText = if (loadingState) secondaryText else primaryText
    }

    Surface(
        modifier = modifier
            .clickable(enabled = !loadingState) {
                onClick()
            },
        shape = shape,
        border = BorderStroke(
            width = borderStrokeWidth,
            color = borderColor
        ),
        color = backGroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = buttonText)

            if (loadingState) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(16.dp),
                    strokeWidth = progressIndicatorStrokeWidth,
                    color = progressIndicatorColor
                )
            }
        }
    }
}