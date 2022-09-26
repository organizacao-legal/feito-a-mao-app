package com.orglegal.fam.features.catalog.presentation.full_list

import com.orglegal.fam.features.catalog.domain.model.Category

data class FullListState(
    val success: Category? = null,
    val failure: String? = null
)
