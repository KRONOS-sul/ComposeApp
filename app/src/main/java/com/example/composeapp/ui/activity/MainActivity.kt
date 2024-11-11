package com.example.composeapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.screen.MainScreen
import com.example.composeapp.ui.screen.ProfileScreen
import com.example.composeapp.ui.screen.onboard.OnboardingScreen
import com.example.composeapp.utils.SharedUtil
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    private fun MyApp() {
        val navController = rememberNavController()
        val sharedUtil = SharedUtil(this)
        val startDestination = if (sharedUtil.isBoardingDone) MainScreen else OnboardingScreen

        NavHost(navController, startDestination = startDestination) {
            composable<MainScreen> {
                MainScreen(
                    navigateToProfileScreen = {
                        navController.navigate(ProfileScreen)
                    })
            }
            composable<ProfileScreen> { ProfileScreen() }
            composable<OnboardingScreen> { OnboardingScreen(navController) }
        }
    }

    @Serializable
    object MainScreen

    @Serializable
    object ProfileScreen

    @Serializable
    object OnboardingScreen

}
