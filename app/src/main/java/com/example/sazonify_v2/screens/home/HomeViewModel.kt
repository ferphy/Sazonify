package com.example.sazonify_v2.screens.home

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
        MutableStateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>>(DataOrException(loading = false))
    val recipesByType: StateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>> = _recipesByType

    private val _recipesBySort =
        MutableStateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>>(DataOrException(loading = false))
    val recipesBySort: StateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>> = _recipesBySort

    private val _recipesByTime =
        MutableStateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>>(DataOrException(loading = false))
    val recipesByTime: StateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>> = _recipesByTime

    /**
     * Función genérica para manejar solicitudes y actualizar un flujo específico.
     *
     * @param flow El flujo de estado que se actualizará.
     * @param type El tipo de receta (opcional).
     * @param sort El criterio de ordenación (opcional).
     * @param maxReadyTime El tiempo máximo de preparación en minutos (opcional).
     * @param number El número de recetas a obtener (opcional, valor por defecto 10).
     */
    private fun fetchRecipes(
        flow: MutableStateFlow<DataOrException<RecipeByQueryList, Boolean, Exception>>,
        type: String? = null,
        sort: String? = null,
        maxReadyTime: Int? = null,
        number: Int = 10
    ) {
        viewModelScope.launch {
            flow.value = DataOrException(loading = true)
            try {
                val result = repository.getRecipes(
                    type = type,
                    sort = sort,
                    maxReadyTime = maxReadyTime,
                    number = number
                )
                flow.value = result
            } catch (e: Exception) {
                flow.value = DataOrException(e = e)
            }
        }
    }

    fun getRecipesByType(type: String, number: Int = 10) {
        fetchRecipes(_recipesByType, type = type, number = number)
    }

    fun getRecipesBySort(sort: String, number: Int = 10) {
        fetchRecipes(_recipesBySort, sort = sort, number = number)
    }

    fun getRecipesByTime(time: Int, number: Int = 10) {
        fetchRecipes(_recipesByTime, maxReadyTime = time, number = number)
    }
}

