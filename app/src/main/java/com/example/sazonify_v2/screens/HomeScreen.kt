package com.example.sazonify_v2.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.ui.theme.customColors

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val recipesByType = viewModel.recipesByType.collectAsState()
    val recipesBySort = viewModel.recipesBySort.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getRecipesByType(type = "dessert")
        viewModel.getRecipesBySort(sort = "popularity")
    }

    HomeScreenContent(
        recipesByType = recipesByType.value,
        recipesBySort = recipesBySort.value
    )

}

@Composable
fun HomeScreenContent(
    recipesByType: DataOrException<RecipeByQueryList, Boolean, Exception>,
    recipesBySort: DataOrException<RecipeByQueryList, Boolean, Exception>
) {

}
