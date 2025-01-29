package com.example.sazonify_v2.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sazonify_v2.data.DataOrException
import com.example.sazonify_v2.ui.theme.customColors

@Composable
fun <T> DisplayRecipesRow(
    recipes: DataOrException<T, Boolean, Exception>,
    content: @Composable (T) -> Unit,
) {
    when {
        recipes.loading == true -> {
            CircularProgressIndicator()
        }

        recipes.e != null -> { // ❌ Manejo de errores
            Text(
                text = "Error: ${recipes.e}",
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }

        recipes.data == null || (recipes.data is List<*> && (recipes.data as List<*>).isEmpty()) -> {// ℹ️ Lista vacía
            Text(
                text = "No recipes available",
                color = MaterialTheme.customColors.title,
                modifier = Modifier.padding(16.dp)
            )
        }

        else -> { //Si tenemos datos!!
            content(recipes.data!!)
        }
    }
}

