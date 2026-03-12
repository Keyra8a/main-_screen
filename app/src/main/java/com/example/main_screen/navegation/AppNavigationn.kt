package com.example.main_screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.main_screen.screens.LoginScreen
import com.example.main_screen.screens.SignUpScreen
import com.example.main_screen.screens.WelcomeScreen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome"){
            WelcomeScreen(navController)
        }

        composable ("signup"){
            SignUpScreen(navController)
        }
        composable ("loginscreen"){
            LoginScreen(navController)
        }
    }
}