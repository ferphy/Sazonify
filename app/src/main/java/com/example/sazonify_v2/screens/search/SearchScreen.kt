package com.example.sazonify_v2.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.sazonify_v2.widgets.TopAppBarWithSearch

@Composable
fun SearchScreen(
    navController: NavHostController,
    title: String,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBarWithSearch(
            navController,
            title = title
        )
        LazyColumn {
            items(10) {
            }
        }
    }
}