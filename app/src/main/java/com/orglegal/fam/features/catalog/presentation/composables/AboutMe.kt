package com.orglegal.fam.features.catalog.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.orglegal.fam.R
import com.orglegal.fam.features.catalog.domain.model.About
import com.orglegal.fam.features.catalog.domain.model.Social
import com.orglegal.fam.features.catalog.domain.model.mockedAbout
import com.orglegal.fam.ui.theme.FeitoAMãoTheme
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import com.orglegal.fam.features.catalog.utils.composables.ExpandableText

@Preview
@Composable
fun PreviewAboutMe() {
    FeitoAMãoTheme {
        AboutMe(mockedAbout)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAboutMeDark() {
    FeitoAMãoTheme {
        AboutMe(mockedAbout)
    }
}

@Composable
fun AboutMe(about: About) {
    val context = LocalContext.current

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
                verticalAlignment = Alignment.Top,

                ) {
                AsyncImage(
                    model = about.owner.imageUrl,
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.person_placeholder),
                    modifier = Modifier
                        .padding(top = 8.dp)
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
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onBackground
                    )
                    ExpandableText(
                        text = about.owner.biography,
                        maxLines = 4,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            LazyRow(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .background(
                        color = MaterialTheme.colors.onSurface,
                        shape = MaterialTheme.shapes.medium
                    ),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 3.dp)
            ) {
                items(
                    items = about.socials,
                    itemContent = {
                        SocialItemList(
                            social = it,
                            itemClickCallback = { url ->
                                if (url.isNotEmpty()) {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    startActivity(context, intent, null)
                                }
                            })
                    }
                )
            }
        }
    }
}

@Composable
fun SocialItemList(
    social: Social,
    itemClickCallback: (url: String) -> Unit
) {
    val color: ColorFilter = if (isSystemInDarkTheme()) {
        ColorFilter.tint(MaterialTheme.colors.primary)
    } else {
        ColorFilter.tint(Color.White)
    }

    Image(
        modifier = Modifier
            .clickable { itemClickCallback(social.url) }
            .padding(5.dp)
            .size(24.dp),
        painter = painterResource(id = social.type.resId ?: R.drawable.ic_round_image),
        contentDescription = "${social.host} icon",
        colorFilter = color,
    )
}

@Preview
@Composable
fun PreviewAboutError() {
    FeitoAMãoTheme {
        AboutError(errorMessage = "Something happened.")
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAboutErrorDark() {
    FeitoAMãoTheme {
        AboutError(errorMessage = "Something happened.")
    }
}

@Composable
fun AboutError(errorMessage: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
        color = MaterialTheme.colors.surface,
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Error,
                contentDescription = "Error icon",
                tint = MaterialTheme.colors.error
            )
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = errorMessage,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}