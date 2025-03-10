package com.example.sazonify_v2.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.searchById.RecipeById
import com.example.sazonify_v2.ui.theme.customColors
import com.example.sazonify_v2.widgets.CircleWithPercentageAndName
import com.example.sazonify_v2.widgets.IconAndInfo
import com.example.sazonify_v2.widgets.IngredientItem
import com.example.sazonify_v2.widgets.RecipeTitle

@Composable
fun DetailScreen(
    navController: NavHostController,
    recipeId: String,
    viewModel: DetailViewModel = hiltViewModel(),
) {

    val recipe = viewModel.recipe.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getRecipesById(recipeId = recipeId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TitleAndImage(recipe, navController)
        InfoAboutTheRecipe(recipe)
        TitleForDetails("Ingredients")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            val ingredients = recipe.value.data?.extendedIngredients.orEmpty()
            ingredients.forEach { ingredient ->
                IngredientItem(
                    ingredient = ingredient.originalName
                ) {
                    // Guardar el nombre del ingrediente en Room
                }
            }
        }
        TitleForDetails("Instructions")
        Spacer(Modifier.height(25.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            recipe.value.data?.analyzedInstructions?.forEach { steps ->
                steps.steps.forEach { step ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ){
                        Text(
                            text = "Step ${step.number}",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.customColors.title,
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = step.step,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.customColors.subtitle,
                        )
                        Spacer(Modifier.height(16.dp))
                    }


                }
            }
        }


    }

}

@Composable
private fun TitleForDetails(
    text : String
) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.customColors.title,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(horizontal = 14.dp, vertical = 22.dp)
    )
}

@Composable
private fun InfoAboutTheRecipe(recipe: State<DataOrException<RecipeById, Boolean, Exception>>) {
    Row(
        modifier = Modifier
            .padding(horizontal = 28.dp, vertical = 14.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconAndInfo(
            icon = Icons.Outlined.Timer,
            info = "${recipe.value.data?.cookingMinutes.toString()}min"
        )
        IconAndInfo(
            icon = Icons.Outlined.BookmarkBorder,
            info = "Save"
        )
        IconAndInfo(
            icon = Icons.Outlined.Share,
            info = "Share"
        )
    }
    HorizontalDivider(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxWidth(),
        color = MaterialTheme.customColors.title
    )
    Row(
        modifier = Modifier
            .padding(horizontal = 28.dp, vertical = 14.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleWithPercentageAndName(
            percentage = recipe.value.data?.pricePerServing,
            name = "Price"
        )
        CircleWithPercentageAndName(
            percentage = recipe.value.data?.healthScore?.toDouble(),
            name = "Health"
        )
        CircleWithPercentageAndName(
            percentage = recipe.value.data?.spoonacularScore,
            name = "Score"
        )
    }
    HorizontalDivider(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxWidth(),
        color = MaterialTheme.customColors.title
    )
}

@Composable
private fun TitleAndImage(
    recipe: State<DataOrException<RecipeById, Boolean, Exception>>,
    navController: NavHostController
) {
    recipe.value.data?.title?.let {
        RecipeTitle(
            navController,
            modifier = Modifier.padding(14.dp),
            title = it
        )
    }
    AsyncImage(
        model = recipe.value.data?.image,
        contentDescription = recipe.value.data?.title,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
    )
    Spacer(Modifier.height(4.dp))
    recipe.value.data?.creditsText?.let {
        Text(
            text = "By $it",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.customColors.subtitle,
            modifier = Modifier.padding(horizontal = 14.dp)
        )
    }
}