package com.orglegal.fam.features.catalog.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.orglegal.fam.features.catalog.domain.model.Catalog
import com.orglegal.fam.features.catalog.domain.model.Category
import com.orglegal.fam.features.catalog.domain.model.Image
import com.orglegal.fam.features.catalog.domain.model.mockedCatalog
import com.orglegal.fam.ui.theme.FeitoAMãoTheme

@Preview
@Composable
fun PreviewCategory() {
    FeitoAMãoTheme {
        Catalog(mockedCatalog)
    }
}

@Composable
fun Catalog(catalog: Catalog) {
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}

@Composable
fun Category(category: Category) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 5.dp),
        content = {
            items(
                items = category.images,
                itemContent = {
                    CategoryImageItem(image = it)
                })
        })
}

@Composable
fun CategoryImageItem(image: Image) {
    AsyncImage(
        model = image.imageUrl,
        contentDescription = image.contentDescription
    )
}