package com.example.codereview.ComposableScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.codereview.Navigation.BottomNavGraph
import com.example.codereview.Navigation.BottomNavigationBar
import com.example.codereview.code.CodeViewModel

@Composable
fun MainScreen(){

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {

            val codeViewModel: CodeViewModel = viewModel()
            BottomNavGraph(navController = rememberNavController(), codeviewModel = codeViewModel)
        }

    }}