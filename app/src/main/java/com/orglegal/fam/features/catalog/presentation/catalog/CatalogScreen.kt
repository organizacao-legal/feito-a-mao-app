package com.orglegal.fam.features.catalog.presentation.catalog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.orglegal.fam.features.catalog.presentation.composables.*
import com.orglegal.fam.util.UiEvent

@Composable
fun CatalogScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: CatalogViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }


    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { viewModel.refresh() }
    ) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
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
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp),
                            onShowListCompleteClick = {
                                viewModel.onEvent(CatalogEvent.SendToCategoryAllListScreen(category))
                            }
                        )
                    }
                }

                item {
                    state.about?.let { AboutMe(it) }
                }
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            state.catalogError?.let {
                CatalogError(
                    modifier = Modifier
                        .align(Alignment.Center),
                    errorMessage = it
                )
            }
            state.aboutError?.let {
                AboutError(it, modifier = Modifier.align(Alignment.BottomCenter))
            }
        }
    }
}