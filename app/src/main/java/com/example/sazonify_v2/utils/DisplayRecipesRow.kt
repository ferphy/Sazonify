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

        recipes.loading == true -> { //Loading
            CircularProgressIndicator()
        }

        recipes.e != null -> { // Error manager
            Text(
                text = "Error: ${recipes.e}",
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }

        recipes.data == null || (recipes.data is List<*> && (recipes.data as List<*>).isEmpty()) -> {// No data
            Text(
                text = "No recipes available",
                color = MaterialTheme.customColors.title,
                modifier = Modifier.padding(16.dp)
            )
        }

        else -> { //Here we have the data
            content(recipes.data!!)
        }
    }
}

