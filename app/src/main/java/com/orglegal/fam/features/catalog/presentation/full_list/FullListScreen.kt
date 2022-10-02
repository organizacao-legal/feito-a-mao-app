package com.orglegal.fam.features.catalog.presentation.full_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.orglegal.fam.features.catalog.presentation.composables.CatalogError
import com.orglegal.fam.features.catalog.presentation.composables.CategoryImageItem
import com.orglegal.fam.features.catalog.presentation.composables.ImageParameter
import com.orglegal.fam.util.UiEvent

@Composable
fun FullListScreen(
    onPopBackStack: () -> Unit,
    viewModel: FullListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                else -> Unit
            }
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { viewModel.refresh() }) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBar(
                        title = {
                            state.success?.let {
                                Text(text = state.success.name)
                            }
                        },
                        navigationIcon = {
                            IconButton(onClick = { viewModel.onEvent(FullListEvent.PopBackStack) }) {
                                Icon(Icons.Filled.ArrowBackIos, "back icon")
                            }
                        },
                        backgroundColor = Color.Transparent,
                        elevation = 0.dp
                    )
                }
            ) { paddingValues ->
                val padding = PaddingValues(
                    top = paddingValues.calculateTopPadding() + 10.dp,
                    bottom = paddingValues.calculateBottomPadding(),
                    start = 20.dp,
                    end = 20.dp
                )

                state.failure?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        CatalogError(
                            modifier = Modifier
                                .align(Alignment.Center),
                            errorMessage = it
                        )
                    }
                }

                state.success?.let {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(padding)
                    ) {
                        items(it.images) { image ->
                            CategoryImageItem(ImageParameter(image = image))
                        }
                    }
                }
            }

        }
    }
}