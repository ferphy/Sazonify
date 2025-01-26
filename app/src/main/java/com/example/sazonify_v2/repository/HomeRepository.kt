package com.example.sazonify_v2.repository

import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.network.RecipeAPI
import com.example.sazonify_v2.widgets.Constants.API_KEY
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiService: RecipeAPI) {

    suspend fun getRecipes(
        sort: String? = null,
        maxReadyTime: Int? = null,
        type: String? = null,
        number: Int = 10
    ): DataOrException<RecipeByQueryList, Boolean, Exception> {
        return try {
            val response = apiService.getRecipes(
                apiKey = API_KEY,
                sort = sort,
                maxReadyTime = maxReadyTime,
                type = type,
                number = number
            )
            DataOrException(data = response)
        } catch (e: Exception) {
            DataOrException(e = e)
        }
    }
}