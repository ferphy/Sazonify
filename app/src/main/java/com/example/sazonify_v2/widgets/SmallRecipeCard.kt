package com.example.sazonify_v2.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sazonify_v2.navigation.DetailScreenRoute

@Preview(showBackground = true)
@Composable
fun SmallRecipeCard(
    title: String = "Chicken Rice Bowl with a lot of money jejejejjejejeje",
    image: String = "Chicken Rice Bowl",
    recipeId: String = "1",
    navController: NavHostController = NavHostController(LocalContext.current)
) {

    Column(
        modifier = Modifier.height(200.dp).width(150.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Card(
            modifier = Modifier
                .size(150.dp)
                .clickable {
                    navController.navigate(
                        DetailScreenRoute(
                            recipeId
                        )
                    )
                }
        ) {
            AsyncImage(
                model = image,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
        )
    }

}