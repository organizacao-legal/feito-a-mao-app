package com.orglegal.fam.features.catalog.presentation.full_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orglegal.fam.features.catalog.domain.model.Category
import com.orglegal.fam.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
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

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        savedStateHandle.get<Category>("category").let { category ->
            if (category == null) {
                _state.value = _state.value.copy(failure = "Deu erro :c")
            } else {
                _state.value = _state.value.copy(success = category)
            }
        }
    }

    fun onEvent(event: FullListEvent) {
        when(event) {
            is FullListEvent.PopBackStack -> sendUiEvent(UiEvent.PopBackStack)
        }
    }

    fun refresh() {
        //todo: fetch category by id
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}