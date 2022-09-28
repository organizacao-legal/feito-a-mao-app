package com.orglegal.fam.features.catalog.presentation.full_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.orglegal.fam.features.catalog.domain.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FullListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private val _state = mutableStateOf(FullListState())
    val state : State<FullListState> = _state

    init {
        savedStateHandle.get<Category>("category").let { category ->
            if (category == null) {
                _state.value = _state.value.copy(failure = "Deu erro :c")
            } else {
                _state.value = _state.value.copy(success = category)
            }
        }
    }

    fun refresh() {
        //todo: fetch category by id
    }

}