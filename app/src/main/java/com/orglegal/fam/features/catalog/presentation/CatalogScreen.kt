package com.orglegal.fam.features.catalog.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.orglegal.fam.features.catalog.domain.model.mockedAbout
import com.orglegal.fam.features.catalog.presentation.composables.AboutMe
import com.orglegal.fam.features.catalog.presentation.composables.Header
import com.orglegal.fam.ui.theme.FeitoAMãoTheme

@Composable
fun CatalogScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        LazyColumn {
            item {
                Header()

                Column(verticalArrangement = Arrangement.Bottom) {
                    AboutMe(mockedAbout)
                }
            }
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

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewCatalogScreenDark() {
    FeitoAMãoTheme {
        CatalogScreen()
    }
}