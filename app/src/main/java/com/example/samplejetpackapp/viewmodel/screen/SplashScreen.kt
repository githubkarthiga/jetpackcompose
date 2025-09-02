package com.example.samplejetpackapp.viewmodel.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.samplejetpackapp.ui.theme.Screen
import com.example.samplejetpackapp.viewmodel.SplashViewModel

@Composable
fun SplashScreen(navController: NavController, viewModel: SplashViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val nextScreen by viewModel.navigateTo.collectAsState()

    // Navigation effect
    LaunchedEffect(nextScreen) {
        nextScreen?.let {
            navController.navigate(it) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }
    }

    // UI (logo / name etc.)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("My App Logo", style = MaterialTheme.typography.headlineMedium)
    }
}