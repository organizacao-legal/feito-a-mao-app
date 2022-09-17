package com.orglegal.fam.features.catalog.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.orglegal.fam.R

@Composable
fun Header() {
    val color: ColorFilter = if (isSystemInDarkTheme()) {
        ColorFilter.tint(MaterialTheme.colors.primary)
    } else {
        ColorFilter.tint(Color.Black)
    }

    Column(
        modifier = Modifier.padding(top = 8.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_header_logo),
            colorFilter = color,
            contentDescription = "header logo"
        )
    }
}