package com.example.sazonify_v2.screens

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sazonify_v2.ui.theme.customColors

@Composable
fun HomeScreen(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.customColors.background
    ){
        Text(text = "Home Screen")
    }
}