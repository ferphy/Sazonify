package com.example.sazonify_v2.repository

import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.network.RecipeAPI
import com.example.sazonify_v2.utils.Constants.API_KEY
import javax.inject.Inject

class SearchRepository@Inject constructor(private val apiService: RecipeAPI) {

    suspend fun getRecipes(
        query: String? = null,
        number: Int = 10
    ): DataOrException<RecipeByQueryList, Boolean, Exception> {
        return try {
            val response = apiService.getRecipes(
                apiKey = API_KEY,
                query = query,
                number = number
            )
            DataOrException(data = response)
        } catch (e: Exception) {
            DataOrException(e = e)
        }
    }
}