package com.orglegal.fam.features.catalog.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orglegal.fam.features.catalog.domain.model.mockedAbout
import com.orglegal.fam.ui.theme.FeitoAMãoTheme
import com.orglegal.fam.R

@Composable
fun CatalogScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_header_logo),
                contentDescription = "header logo"
            )
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            AboutMe(mockedAbout)
        }
    }
}

@Preview
@Composable
fun PreviewCatalogScreen() {
    FeitoAMãoTheme {
        CatalogScreen()
    }
}