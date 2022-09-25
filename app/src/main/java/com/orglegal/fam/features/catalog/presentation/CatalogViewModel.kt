package com.orglegal.fam.features.catalog.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orglegal.fam.features.catalog.domain.repository.CatalogRepository
import com.orglegal.fam.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val catalogRepository: CatalogRepository
) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private val _state = mutableStateOf(CatalogState())
    val state: State<CatalogState> = _state

    init {
        refresh()
    }

    fun refresh() {
        _state.value = CatalogState()
        onEvent(CatalogEvent.FetchCatalog)
        onEvent(CatalogEvent.FetchAbout)
    }

    fun onEvent(event: CatalogEvent) {
        when (event) {
            CatalogEvent.FetchCatalog -> fetchCatalog()
            CatalogEvent.FetchAbout -> fetchAbout()
        }
    }

    private fun fetchCatalog() {
        viewModelScope.launch {
            when (val response = catalogRepository.getCatalog()) {
                is Resource.Success -> {
                    response.data?.let { catalog ->
                        _state.value = _state.value.copy(
                            catalog = catalog
                        )
                    }
                }
                is Resource.Error -> {
                    response.message?.let { errorMessage ->
                        _state.value = _state.value.copy(
                            catalogError = errorMessage
                        )
                    }
                }
            }
        }
    }

    private fun fetchAbout() {
        viewModelScope.launch {
            when (val response = catalogRepository.getAbout()) {
                is Resource.Success -> {
                    response.data?.let { about ->
                        _state.value = _state.value.copy(
                            about = about
                        )
                    }
                }
                is Resource.Error -> {
                    response.message?.let { errorMessage ->
                        _state.value = _state.value.copy(
                            aboutError = errorMessage
                        )
                    }
                }
            }
        }
    }

}