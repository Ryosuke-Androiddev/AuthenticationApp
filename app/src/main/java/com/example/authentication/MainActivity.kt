package com.example.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.authentication.component.GoogleButton
import com.example.authentication.component.Message
import com.example.authentication.component.MessageBar
import com.example.authentication.domain.model.MessageBarState
import com.example.authentication.navigation.NavigationGraph
import com.example.authentication.ui.theme.AuthenticationTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthenticationTheme {
//                val navController = rememberNavController()
//                NavigationGraph(navController = navController)

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                }
            }
        }
    }
}