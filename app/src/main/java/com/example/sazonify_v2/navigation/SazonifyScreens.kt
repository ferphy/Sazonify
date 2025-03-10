package com.example.sazonify_v2.navigation

import kotlinx.serialization.Serializable

@Serializable
data object HomeScreenRoute{}

@Serializable
data class DetailScreenRoute(
    val recipeId: String
)

@Serializable
data class ResultsScreenRoute(
    val title: String,
)

@Serializable
data object GroceryScreenRoute{}

@Serializable
data object SavedRecipesScreenRoute{}
