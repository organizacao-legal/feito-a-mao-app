package com.orglegal.fam.features.catalog.presentation.full_list

sealed class FullListEvent {
    object PopBackStack : FullListEvent()
}