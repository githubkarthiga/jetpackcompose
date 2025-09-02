package com.example.samplejetpackapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplejetpackapp.ui.theme.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _navigateTo = MutableStateFlow<String?>(null)
    val navigateTo = _navigateTo.asStateFlow()

    init {
        startSplashTimer()
    }

    private fun startSplashTimer() {
        viewModelScope.launch {
            delay(2000) // 2 seconds splash
            // right now no API → just always go to Login
            _navigateTo.value = Screen.Login.route
        }
    }
}