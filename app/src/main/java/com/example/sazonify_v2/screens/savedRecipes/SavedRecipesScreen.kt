package com.example.sazonify_v2.screens.savedRecipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.sazonify_v2.navigation.HomeScreenRoute
import com.example.sazonify_v2.navigation.SavedRecipesScreenRoute
import com.example.sazonify_v2.widgets.BottomBar

@Composable
fun SavedRecipesScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar(navController = navController, actualPage =SavedRecipesScreenRoute) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "SavedRecipesScreen Screen")
        }
    }
}