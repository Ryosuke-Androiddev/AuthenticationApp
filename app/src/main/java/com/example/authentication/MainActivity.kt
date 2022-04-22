package com.example.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.authentication.ui.theme.AuthenticationTheme
import dagger.hilt.android.AndroidEntryPoint

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