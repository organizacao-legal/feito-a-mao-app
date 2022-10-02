package com.orglegal.fam.features.catalog.presentation.composables

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NearbyError
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.orglegal.fam.R
import com.orglegal.fam.features.catalog.domain.model.Image
import com.orglegal.fam.features.catalog.domain.model.mockedCatalog
import com.orglegal.fam.ui.theme.FeitoAMãoTheme

@Composable
fun StaggeredCategoryGrid(
    modifier: Modifier = Modifier,
    images: List<Image>,
    onShowListCompleteClick: () -> Unit
) {
    val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2) - 25.dp
    val itemModifier = Modifier.size(itemSize)

    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            )
            {
                images.firstOrNull()?.let { image ->
                    CategoryImageItem(
                        param = ImageParameter(
                            modifier = itemModifier,
                            image = image,
                        )
                    )
                }
                images.getOrNull(1)?.let { image ->
                    CategoryImageItem(
                        param = ImageParameter(
                            modifier = itemModifier,
                            image = image,
                        )
                    )
                }
            }
            images.getOrNull(2)?.let { image ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    CategoryImageItem(
                        param = ImageParameter(
                            modifier = itemModifier,
                            image = image,
                        )
                    )
                    images.getOrNull(3)?.let { image ->
                        CategoryImageItem(
                            param = ImageParameter(
                                modifier = itemModifier,
                                image = image,
                                isLast = true,
                                listSize = images.size - 3
                            ),
                            onShowListCompleteClick = onShowListCompleteClick
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryImageItem(param: ImageParameter, onShowListCompleteClick: () -> Unit? = {}) {
    Surface(elevation = 6.dp, shape = RoundedCornerShape(8.dp)) {
        param.run {
            val modifier = if (isLast) modifier.blur(5.dp) else modifier
            AsyncImage(
                modifier = modifier,
                model = image.imageUrl,
                contentDescription = image.contentDescription,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_round_image),
                filterQuality = FilterQuality.Low
            )
            if (isLast) {
                Box(modifier = Modifier.clickable { onShowListCompleteClick() }) {
                    Box(
                        modifier = modifier
                            .background(Color(0xB0000000))
                    )
                    Text(
                        text = "+ $listSize",
                        modifier = Modifier.align(Alignment.Center),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}

data class ImageParameter(
    val modifier: Modifier = Modifier,
    val image: Image,
    val isLast: Boolean = false,
    val listSize: Int? = null
)

@Preview
@Composable
fun PreviewStaggeredGrid() {
    FeitoAMãoTheme {
        StaggeredCategoryGrid(images = mockedCatalog.catalog.first().images) {}
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCatalogError() {
    FeitoAMãoTheme {
        CatalogError("There was an error")
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewCatalogErrorDark() {
    FeitoAMãoTheme {
        CatalogError("There was an error")
    }
}

@Composable
fun CatalogError(errorMessage: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 20.dp),
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