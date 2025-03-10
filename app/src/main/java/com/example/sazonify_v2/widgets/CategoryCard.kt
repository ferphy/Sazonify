package com.example.sazonify_v2.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sazonify_v2.R
import com.example.sazonify_v2.navigation.ResultsScreenRoute

@Preview(showBackground = true)
@Composable
fun CategoryCard(
    title: String = "Burger",
    image: Int = R.drawable.burger_category,
    navController: NavHostController = NavHostController(LocalContext.current)
){

    Column(
        modifier = Modifier.height(240.dp).width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Card(
            modifier = Modifier
                .size(200.dp)
                .clickable {
                    navController.navigate(ResultsScreenRoute(
                        title = title
                    ))
                },
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = image), // ✅ Corregido
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