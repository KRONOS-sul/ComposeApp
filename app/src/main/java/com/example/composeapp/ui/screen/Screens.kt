package com.example.composeapp.ui.screen

sealed class Screens(val route: String) {

    data object MainScreen : Screens("main_screen")
    data object ProfileScreen : Screens("profile_screen")
    data object OnboardingScreen : Screens("onboarding_screen")
}