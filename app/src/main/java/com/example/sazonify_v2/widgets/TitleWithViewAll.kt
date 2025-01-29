package com.example.sazonify_v2.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sazonify_v2.R
import com.example.sazonify_v2.ui.theme.customColors


@Preview(showBackground = true)
@Composable
fun TitleWithViewAll(
    title: String = "Featured Recipes",
    modifier: Modifier,
    navController: NavHostController,
) {


    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(MaterialTheme.customColors.background),

        ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold      ,
                color = MaterialTheme.customColors.title
            )

            Text(
                text = stringResource(R.string.view_all),
                style = MaterialTheme.typography.titleSmall.copy(
                    textDecoration = TextDecoration.Underline
                ),
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.customColors.subtitle,
                modifier = Modifier.padding(end = 8.dp)
            )

        }
    }
}