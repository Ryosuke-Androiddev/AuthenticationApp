package com.example.authentication.presentation.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.authentication.R
import com.example.authentication.presentation.component.GoogleButton

@Composable
fun LoginCentralContent(
    signedInState: Boolean,
    onClick: () -> Unit
) {
    Image(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .size(120.dp),
        painter = painterResource(id = R.drawable.ic_google_logo),
        contentDescription = "Google Logo"
    )
    Text(
        text = "Sign In",
        fontWeight = FontWeight.Bold,
        fontSize = MaterialTheme.typography.h5.fontSize
    )
    Text(
        modifier = Modifier
            .alpha(ContentAlpha.medium)
            .padding(bottom = 40.dp, top = 4.dp),
        text = "Please Sign In with Google Account",
        fontSize = MaterialTheme.typography.subtitle1.fontSize,
        textAlign = TextAlign.Center
    )
    GoogleButton(
        loadingState = signedInState,
        onClick = onClick
    )
}