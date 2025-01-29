package com.example.sazonify_v2.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.ui.theme.customColors
import com.example.sazonify_v2.widgets.SmallRecipeCard
import com.example.sazonify_v2.widgets.TitleWithViewAll

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
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeScreenContent(
            recipesBySort = recipesBySort.value,
            recipesByTime = recipesByTime.value,
            navController = navController,
            viewModel = viewModel
        )
    }
}

@Composable
fun HomeScreenContent(
    recipesBySort: DataOrException<RecipeByQueryList, Boolean, Exception>,
    recipesByTime: DataOrException<RecipeByQueryList, Boolean, Exception>,
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    DisplayRecipeSection("Featured Recipes", recipesBySort, navController)
    Spacer(modifier = Modifier.padding(14.dp))
    DisplayRecipeSection("Ready in 15min", recipesByTime, navController)
    Spacer(modifier = Modifier.padding(14.dp))
    CategoryRow(viewModel, navController)
}


@Composable
fun CategoryRow(recipesByType: HomeViewModel, navController: NavHostController) {
    TitleWithViewAll(
        title = "Featured Recipes",
        modifier = Modifier.padding(14.dp),
        navController = navController
    )
}

@Composable
fun DisplayRecipeSection(
    title: String,
    recipes: DataOrException<RecipeByQueryList, Boolean, Exception>,
    navController: NavHostController
) {
    TitleWithViewAll(
        title = title,
        modifier = Modifier.padding(14.dp),
        navController = navController
    )

    DisplayRecipesRow(recipes) { recipesData ->
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 14.dp)
        ) {
            val results = recipesData.results
            items(results.size) { index ->
                SmallRecipeCard(
                    title = results[index].title,
                    image = results[index].image,
                    recipeId = results[index].id.toString(),
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun <T> DisplayRecipesRow(
    recipes: DataOrException<T, Boolean, Exception>,
    content: @Composable (T) -> Unit,
) {
    when {
        recipes.loading == true -> {
            CircularProgressIndicator()
        }

        recipes.e != null -> { // ❌ Manejo de errores
            Text(
                text = "Error: ${recipes.e}",
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }

        recipes.data == null || (recipes.data is List<*> && (recipes.data as List<*>).isEmpty()) -> {// ℹ️ Lista vacía
            Text(
                text = "No recipes available",
                color = MaterialTheme.customColors.title,
                modifier = Modifier.padding(16.dp)
            )
        }

        else -> { //Si tenemos datos!!
            content(recipes.data!!)
        }
    }
}


