package com.example.sazonify_v2.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sazonify_v2.screens.detail.DetailScreen
import com.example.sazonify_v2.screens.home.HomeScreen
import com.example.sazonify_v2.screens.home.HomeViewModel
import com.example.sazonify_v2.screens.search.SearchScreen

@Composable
fun SazonifyNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreenRoute
    ) {
        composable<HomeScreenRoute> {

            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }
        composable<DetailScreenRoute> {

            val argsDetail = it.toRoute<DetailScreenRoute>()

            DetailScreen(
                navController = navController,
                recipeId = argsDetail.recipeId
            )
        }
        composable<SearchScreenRoute> {

            val argsSearch = it.toRoute<SearchScreenRoute>()
            SearchScreen(
                navController = navController,
                title = argsSearch.title,
            )
        }

    }
}