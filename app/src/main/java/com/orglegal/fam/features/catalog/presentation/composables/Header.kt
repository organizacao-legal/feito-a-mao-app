package com.orglegal.fam.features.catalog.presentation.composables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orglegal.fam.R
import com.orglegal.fam.ui.theme.FeitoAMãoTheme

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    FeitoAMãoTheme {
        Header()
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun HeaderPreviewDark() {
    FeitoAMãoTheme {
        Header()
    }
}

@Composable
fun Header() {
    val color = ColorFilter.tint(MaterialTheme.colors.onBackground)

    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
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