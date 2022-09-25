package com.orglegal.fam.features.catalog.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.orglegal.fam.features.catalog.presentation.composables.*

@Composable
fun CatalogScreen(
    viewModel: CatalogViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing),
            onRefresh = { viewModel.refresh() }
        ) {
            LazyColumn {
                item {
                    Header()
                }
                state.catalog?.let {
                    items(items = it.catalog) { category ->
                        Text(
                            modifier = Modifier.padding(start = 32.dp, top = 16.dp, bottom = 16.dp),
                            text = category.name,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )
                        )
                        StaggeredCategoryGrid(
                            images = category.images,
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
                        ) {
                            // todo: send to show complete list screen
                        }
                    }
                }

                item {
                    state.about?.let { AboutMe(it) }
                }

                item {
                    state.aboutError?.let { AboutError(it) }
                }
            }
        }
    }
}