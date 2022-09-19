package com.orglegal.fam.features.catalog.presentation.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.NearbyError
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.orglegal.fam.R
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

@Preview
@Composable
fun PreviewCategoryItem() {
    FeitoAMãoTheme {
        CategoryGrid(mockedCatalog.catalog.first())
    }
}

@Composable
fun Catalog(catalog: Catalog) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items = catalog.catalog) {
            CategoryGrid(category = it)
//            CategoryLinear(category = it)
        }
    }
}

@Composable
fun CategoryGrid(category: Category) {
    val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2)
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            modifier = Modifier.padding(start = 5.dp, bottom = 16.dp),
            text = category.name
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(
                    items = category.images,
                    itemContent = {
                        CategoryImageItem(image = it, Modifier.size(itemSize))
                    })
            })
    }

}

@Composable
fun CategoryLinear(category: Category) {
    LazyColumn {
        item {
            Text(
                modifier = Modifier.padding(start = 5.dp, bottom = 16.dp),
                text = category.name
            )
        }

        items(category.images){
            CategoryImageItem(
                image = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(
                        ratio = 1f,
                        matchHeightConstraintsFirst = true
                    )
            )
        }
    }
}

@Composable
fun CategoryImageItem(image: Image, modifier: Modifier) {
    AsyncImage(
        modifier = modifier,
        model = image.imageUrl,
        contentDescription = image.contentDescription,
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.ic_round_image)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCatalogError(){
    FeitoAMãoTheme {
        CatalogError("There was an error")
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewCatalogErrorDark(){
    FeitoAMãoTheme {
        CatalogError("There was an error")
    }
}

@Composable
fun CatalogError(errorMessage: String) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(50.dp),
            imageVector = Icons.Default.NearbyError,
            contentDescription = "Error icon",
            tint = MaterialTheme.colors.error
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = errorMessage,
            color = MaterialTheme.colors.onBackground
        )
    }
}
