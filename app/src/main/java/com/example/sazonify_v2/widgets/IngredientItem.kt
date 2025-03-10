package com.example.sazonify_v2.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sazonify_v2.model.searchById.Ingredient
import com.example.sazonify_v2.ui.theme.customColors

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    ingredient: String,
    isClicked: (Boolean) -> Unit
) {
    var isClickedValue by remember { mutableStateOf(false) }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!isClickedValue) {
            Card(
                modifier = Modifier
                    .size(18.dp)
                    .clickable {
                        isClickedValue = true
                        isClicked(isClickedValue)
                    },
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.customColors.background
                ),
                border = BorderStroke(1.dp, MaterialTheme.customColors.title)
            ) {}
        } else {
            Card(
                modifier = Modifier
                    .size(18.dp)
                    .clickable {
                        isClickedValue = false
                        isClicked(isClickedValue)
                    },
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.customColors.special
                ),
                border = BorderStroke(1.dp, MaterialTheme.customColors.title)
            ) {}
        }
        Spacer(Modifier.width(8.dp))
        Text(
            text = ingredient,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.customColors.title,
        )

    }

}