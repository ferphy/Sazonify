package com.example.sazonify_v2.model.recipeByQuery

data class RecipeByQueryList(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)