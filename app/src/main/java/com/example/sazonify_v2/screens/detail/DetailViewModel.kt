package com.example.sazonify_v2.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.model.searchById.RecipeById
import com.example.sazonify_v2.repository.DetailRepository
import com.example.sazonify_v2.utils.Constants.API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: DetailRepository): ViewModel() {

    private val _recipe =
        MutableStateFlow<DataOrException<RecipeById, Boolean, Exception>>(DataOrException(loading = false))
    val recipe: StateFlow<DataOrException<RecipeById, Boolean, Exception>> = _recipe

    private fun fetchRecipes(
        flow: MutableStateFlow<DataOrException<RecipeById, Boolean, Exception>>,
        recipeId: String
    ) {
        viewModelScope.launch {
            flow.value = DataOrException(loading = true)
            try {
                val result = repository.findById(
                    recipeId = recipeId
                )
                flow.value = result
            } catch (e: Exception) {
                flow.value = DataOrException(e = e)
            }
        }
    }
    fun getRecipesById(recipeId: String) {
        fetchRecipes(_recipe, recipeId = recipeId)
    }

}