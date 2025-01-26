package com.example.sazonify_v2.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sazonify_v2.screens.HomeScreen
import com.example.sazonify_v2.screens.HomeViewModel

@Composable
fun SazonifyNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreenRoute
    ){
        composable<HomeScreenRoute>{

            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

    }
}