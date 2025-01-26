package com.example.sazonify_v2.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val recipesBySort = viewModel.recipesBySort.collectAsState()
    val recipesByTime = viewModel.recipesByTime.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getRecipesBySort(sort = "popularity")
        viewModel.getRecipesByTime(time = 15)
    }

    HomeScreenContent(
        recipesBySort = recipesBySort.value,
        recipesByTime = recipesByTime.value,
        navController = navController,
        viewModel = viewModel
    )
}

@Composable
fun HomeScreenContent(
    recipesBySort: DataOrException<RecipeByQueryList, Boolean, Exception>,
    recipesByTime: DataOrException<RecipeByQueryList, Boolean, Exception>,
    navController: NavHostController,
    viewModel: HomeViewModel
) {

    FeaturedRecipesRow(recipesBySort)
    TimeRecipesRow(recipesByTime)
    CategoryRow(viewModel)

}



@Composable
fun FeaturedRecipesRow(recipesBySort: DataOrException<RecipeByQueryList, Boolean, Exception>) {

}

@Composable
fun TimeRecipesRow(recipesByTime: DataOrException<RecipeByQueryList, Boolean, Exception>) {

}

@Composable
fun CategoryRow(recipesByType: HomeViewModel) {

}

