package com.example.codereview.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.codereview.ComposableScreens.LoginScreen
import com.example.codereview.ComposableScreens.MainScreen
import com.example.codereview.ComposableScreens.SignupScreen
import com.example.codereview.ComposableScreens.SplashScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Signup.route) {
            SignupScreen(navController)
        }

        // 🔑 ONLY entry to bottom navigation
        composable(Screen.Main.route) {
            MainScreen()
        }
    }
}

