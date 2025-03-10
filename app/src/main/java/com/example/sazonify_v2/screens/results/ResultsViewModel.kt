package com.example.sazonify_v2.screens.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(private val repository: SearchRepository) : ViewModel() {

    private val _recipesByType =
        MutableStateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>>(DataOrException(loading = false))
    val recipesByType: StateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>> = _recipesByType

    private fun fetchRecipes(
        flow: MutableStateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>>,
        query: String? = null,
        number: Int = 10
    ) {
        viewModelScope.launch {
            flow.value = DataOrException(loading = true)
            try {
                val result = repository.getRecipes(
                    query = query,
                    number = number
                )
                flow.value = result
            } catch (e: Exception) {
                flow.value = DataOrException(e = e)
            }
        }
    }

    fun getRecipesByType(query: String, number: Int = 10) {
        fetchRecipes(_recipesByType, query = query, number = number)
    }

}