package com.example.sazonify_v2.screens.grocery


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
import com.example.sazonify_v2.navigation.GroceryScreenRoute
import com.example.sazonify_v2.navigation.HomeScreenRoute
import com.example.sazonify_v2.widgets.BottomBar

@Composable
fun GroceryScreen(navController : NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar(navController = navController, actualPage = GroceryScreenRoute) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "Grocery Screen")
        }
    }

}