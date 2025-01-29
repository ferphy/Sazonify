package com.example.sazonify_v2.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sazonify_v2.utils.DisplayRecipesRow
import com.example.sazonify_v2.widgets.MediumRecipeCard
import com.example.sazonify_v2.widgets.SmallRecipeCard
import com.example.sazonify_v2.widgets.TopAppBarWithSearch

@Composable
fun SearchScreen(
    navController: NavHostController,
    title: String,
    viewModel: SearchViewModel
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
            title = title
        )
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