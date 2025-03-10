package com.example.sazonify_v2.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sazonify_v2.ui.theme.customColors

@Preview
@Composable
fun CircleWithPercentageAndName(
    percentage: Double? = 472.2,
    name: String = "Protein"
) {
    Column(
        modifier = Modifier.height(108.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier.size(85.dp),
            shape = CircleShape,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.customColors.cards
            ),
            border = BorderStroke(1.dp, MaterialTheme.customColors.title)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val truncated = percentage?.let { String.format("%.2f", it) } ?: "0.00"
                Text(
                    text = truncated,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.customColors.title,
                )
            }
        }
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.customColors.title,
        )
    }
}