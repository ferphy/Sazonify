package com.example.sazonify_v2.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sazonify_v2.screens.detail.DetailScreen
import com.example.sazonify_v2.screens.detail.DetailViewModel
import com.example.sazonify_v2.screens.grocery.GroceryScreen
import com.example.sazonify_v2.screens.home.HomeScreen
import com.example.sazonify_v2.screens.home.HomeViewModel
import com.example.sazonify_v2.screens.results.ResultScreen
import com.example.sazonify_v2.screens.results.ResultsViewModel
import com.example.sazonify_v2.screens.savedRecipes.SavedRecipesScreen

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
            val viewModel: DetailViewModel = hiltViewModel()

            DetailScreen(
                navController = navController,
                recipeId = argsDetail.recipeId,
                viewModel = viewModel
            )
        }
        composable<ResultsScreenRoute> {

            val viewModel: ResultsViewModel = hiltViewModel()
            val argsSearch = it.toRoute<ResultsScreenRoute>()

            ResultScreen(
                navController = navController,
                title = argsSearch.title,
                viewModel = viewModel
            )
        }

        composable<GroceryScreenRoute> {
            GroceryScreen(navController = navController)
        }

        composable<SavedRecipesScreenRoute> {
            SavedRecipesScreen(navController = navController)
        }



    }
}