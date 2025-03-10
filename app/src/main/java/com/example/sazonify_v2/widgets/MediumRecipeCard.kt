package com.example.sazonify_v2.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sazonify_v2.navigation.DetailScreenRoute
import com.example.sazonify_v2.ui.theme.customColors

@Preview(showBackground = true)
@Composable
fun MediumRecipeCard(
    title: String = "Chicken Rice Bowl",
    image: String = "Chicken Rice Bowl",
    recipeId: String = "1",
    navController: NavHostController = NavHostController(LocalContext.current),
    isClicked: (Boolean) -> Unit = {}
) {

    val isFavorite = remember { mutableStateOf(false) }


    Card(
        modifier = Modifier
            .height(300.dp)
            .width(360.dp)
            .clickable {
                navController.navigate(
                    DetailScreenRoute(
                        recipeId
                    )
                )
            },
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.customColors.cards
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = MaterialTheme.shapes.large
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.customColors.title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Text(
                            text = "Tasty!",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.customColors.subtitle,
                        )
                        Text(
                            text = "45min",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.customColors.subtitle,
                        )
                    }

                    if (isFavorite.value) {
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    isFavorite.value = false
                                    isClicked.invoke(false)
                                    //Call to room database to remove
                                },
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = "Remove from favorites",
                            tint = MaterialTheme.customColors.special
                        )
                    } else {
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    isFavorite.value = true
                                    isClicked.invoke(true)
                                    //Call to room database to added
                                },
                            imageVector = Icons.Default.BookmarkBorder,
                            contentDescription = "make it fav",
                        )
                    }

                }


            }

        }

    }


}