package com.example.sazonify_v2.network

import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.model.searchById.RecipeById
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeAPI {

    @GET("random")
    suspend fun getRecipeById(
        @Query("apiKey") apiKey: String,
        @Query("number") number: Int = 10
    ): RecipeById

    //Aqui si buscas pasta te devuelve id//TItle//IMAGE//IMAGETYPE
    @GET("complexSearch")
    suspend fun getRecipes(
        @Query("query") query: String? = null,
        @Query("apiKey") apiKey: String,
        @Query("sort") sort: String? = null,
        @Query("maxReadyTime") maxReadyTime: Int? = null,
        @Query("type") type: String? = null,
        @Query("diet") diet: String? = null,
        @Query("number") number: Int = 10
    ): RecipeByQueryList
}