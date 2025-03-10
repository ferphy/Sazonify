package com.example.sazonify_v2.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalGroceryStore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sazonify_v2.navigation.GroceryScreenRoute
import com.example.sazonify_v2.navigation.HomeScreenRoute
import com.example.sazonify_v2.navigation.SavedRecipesScreenRoute
import com.example.sazonify_v2.ui.theme.customColors

@Composable
fun BottomBar(navController: NavController, actualPage: Any) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .background(MaterialTheme.customColors.background),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconAndName("Home", HomeScreenRoute, actualPage, navController)
            IconAndName("Saved", SavedRecipesScreenRoute, actualPage, navController)
            IconAndName("Grocery", GroceryScreenRoute, actualPage, navController)
        }
    }
}

@Composable
private fun IconAndName(
    name: String,
    route: Any, // Se pasa la ruta correspondiente
    actualPage: Any,
    navController: NavController
) {
    val icon = when (route) {
        HomeScreenRoute -> if (actualPage == HomeScreenRoute) Icons.Filled.Home else Icons.Outlined.Home
        SavedRecipesScreenRoute -> if (actualPage == SavedRecipesScreenRoute) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder
        GroceryScreenRoute -> if (actualPage == GroceryScreenRoute) Icons.Filled.ShoppingCart else Icons.Outlined.LocalGroceryStore
        else -> Icons.Outlined.Home
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(enabled = actualPage != route) {
            navController.navigate(route)
        }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = name,
            tint = MaterialTheme.customColors.title
        )
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.customColors.title
        )
    }
}
