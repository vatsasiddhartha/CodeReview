package com.example.codereview.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.codereview.ComposableScreens.CodecheckScreen
import com.example.codereview.ComposableScreens.CodeprogressScreen
import com.example.codereview.ComposableScreens.CoderunScreen
import com.example.codereview.ComposableScreens.MainScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {

   NavHost(navController = navController, startDestination = Screen.Home.route) {
       composable(Screen.Home.route){
           CoderunScreen()
       }

       composable(Screen.Search.route){
           CodecheckScreen()
       }
       composable(Screen.Profile.route){
           CodeprogressScreen()
       }
   }
}
