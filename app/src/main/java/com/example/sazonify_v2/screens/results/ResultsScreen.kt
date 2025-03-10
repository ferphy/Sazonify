package com.example.sazonify_v2.screens.results

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sazonify_v2.utils.DisplayRecipesRow
import com.example.sazonify_v2.widgets.MediumRecipeCard
import com.example.sazonify_v2.widgets.TopAppBarWithSearch

@Composable
fun ResultScreen(
    navController: NavHostController,
    title: String,
    viewModel: ResultsViewModel
) {
    val recipesBySort = viewModel.recipesByType.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getRecipesByType(query = title)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBarWithSearch(
            navController,
            title = title,
            modifier = Modifier.padding(14.dp),
            isHomeScreen = false
        )
        Spacer(modifier = Modifier.height(16.dp))
        DisplayRecipesRow(recipesBySort.value) { recipesData ->
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(horizontal = 14.dp)
            ) {
                val results = recipesData.results
                items(results.size) { index ->
                    MediumRecipeCard(
                        title = results[index].title,
                        image = results[index].image,
                        recipeId = results[index].id.toString(),
                        navController = navController
                    )
                }
            }
        }
    }
}