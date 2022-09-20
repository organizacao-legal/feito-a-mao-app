package com.orglegal.fam.features.catalog.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.orglegal.fam.features.catalog.presentation.composables.AboutError
import com.orglegal.fam.features.catalog.presentation.composables.AboutMe
import com.orglegal.fam.features.catalog.presentation.composables.CatalogError
import com.orglegal.fam.features.catalog.presentation.composables.Header
import com.orglegal.fam.ui.theme.FeitoAMãoTheme

@Composable
fun CatalogScreen(
    viewModel: CatalogViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Header()

        state.catalogError?.let { CatalogError(errorMessage = it) }

        // Footer
        Column(verticalArrangement = Arrangement.Bottom) {
            state.about?.let { AboutMe(it) }
            state.aboutError?.let { AboutError(it) }
        }
//        LazyColumn {
//            item {
//            }
//        }

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