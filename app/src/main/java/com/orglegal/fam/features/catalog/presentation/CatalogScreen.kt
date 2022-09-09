package com.orglegal.fam.features.catalog.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.orglegal.fam.R
import com.orglegal.fam.features.catalog.domain.model.About
import com.orglegal.fam.features.catalog.domain.model.mockedAbout
import com.orglegal.fam.ui.theme.FeitoAMãoTheme

@Composable
fun CatalogScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            AboutMe(mockedAbout)
        }
    }
}

@Composable
fun AboutMe(about: About) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
        color = MaterialTheme.colors.surface,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,

                ) {
                AsyncImage(
                    model = about.owner.imageUrl,
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(
                        text = about.owner.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = about.owner.biography,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // todo: do this row dynamically
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .background(
                        color = MaterialTheme.colors.onSurface,
                        shape = MaterialTheme.shapes.medium
                    )
                    .size(height = 40.dp, width = 155.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "instagram icon"
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_whatsapp),
                    contentDescription = "whatsapp icon"
                )
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

@Preview
@Composable
fun PreviewAboutMe() {
    FeitoAMãoTheme {
        AboutMe(mockedAbout)
    }
}