package com.example.samplejetpackapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.samplejetpackapp.ui.theme.SampleJetPackAppTheme
import com.example.samplejetpackapp.ui.theme.Screen
import com.example.samplejetpackapp.viewmodel.screen.HomeScreen
import com.example.samplejetpackapp.viewmodel.screen.LoginScreen
import com.example.samplejetpackapp.viewmodel.screen.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Home.route) { HomeScreen() }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleJetPackAppTheme {
        // Preview content
    }
}