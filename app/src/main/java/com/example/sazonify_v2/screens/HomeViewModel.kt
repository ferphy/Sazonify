package com.example.sazonify_v2.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.model.recipeByQuery.RecipeByQueryList
import com.example.sazonify_v2.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _recipesByType =
        MutableStateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>>(
            DataOrException(loading = false)
        )
    val recipesByType: StateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>> =
        _recipesByType

    private val _recipesBySort =
        MutableStateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>>(
            DataOrException(loading = false)
        )
    val recipesBySort: StateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>> =
        _recipesBySort

    fun getRecipesByType(type: String, number: Int = 10) {
        viewModelScope.launch {
            _recipesByType.value = DataOrException(loading = true)
            try {
                val result = repository.getRecipes(type = type, number = number)
                _recipesByType.value = result
            } catch (e: Exception) {
                _recipesByType.value = DataOrException(e = e)
            }
        }
    }

    fun getRecipesBySort(sort: String, number: Int = 10) {
        viewModelScope.launch {
            _recipesBySort.value = DataOrException(loading = true)
            try {
                val result = repository.getRecipes(sort = sort, number = number)
                _recipesBySort.value = result
            } catch (e: Exception) {
                _recipesBySort.value = DataOrException(e = e)
            }
        }
    }
}

