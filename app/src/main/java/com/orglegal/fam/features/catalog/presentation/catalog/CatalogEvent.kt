package com.orglegal.fam.features.catalog.presentation.catalog

import com.orglegal.fam.features.catalog.domain.model.Category

sealed class CatalogEvent {
    object FetchCatalog : CatalogEvent()
    object FetchAbout : CatalogEvent()
    data class SendToCategoryAllListScreen(val category: Category) : CatalogEvent()
}
