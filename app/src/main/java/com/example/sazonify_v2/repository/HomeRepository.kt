package com.example.sazonify_v2.repository

import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.network.RecipeAPI
import com.example.sazonify_v2.widgets.Constants.API_KEY
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiService: RecipeAPI)  {

    suspend fun getRecipes(
        query: String? = null,
        sort: String? = null,
        maxReadyTime: Int? = null,
        type: String? = null,
        diet: String? = null,
        number: Int = 10
    ): DataOrException<RecipeByQueryList, Boolean, Exception> {
        return try {
            val response = apiService.getRecipes(
                query = query,
                apiKey = API_KEY,
                sort = sort,
                maxReadyTime = maxReadyTime,
                type = type,
                diet = diet,
                number = number
            )
            DataOrException(data = response)
        } catch (e: Exception) {
            DataOrException(e = e)
        }
    }
}