package com.orglegal.fam.features.catalog.presentation

import com.orglegal.fam.features.catalog.domain.model.About
import com.orglegal.fam.features.catalog.domain.model.Catalog

data class CatalogState(
    val catalog: Catalog? = null,
    val catalogError: String? = null,
    val about: About? = null,
    val aboutError: String? = null
)
