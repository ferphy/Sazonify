package com.example.sazonify_v2.repository

import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.model.searchById.RecipeById
import com.example.sazonify_v2.network.RecipeAPI
import com.example.sazonify_v2.utils.Constants.API_KEY
import javax.inject.Inject

class DetailRepository  @Inject constructor(private val apiService: RecipeAPI) {

    suspend fun findById(
        recipeId: String
    ): DataOrException<RecipeById, Boolean, Exception> {
        return try {
            val response = apiService.findById(
                apiKey = API_KEY,
                recipeId = recipeId
            )
            DataOrException(data = response)
        } catch (e: Exception) {
            DataOrException(e = e)
        }
    }
}