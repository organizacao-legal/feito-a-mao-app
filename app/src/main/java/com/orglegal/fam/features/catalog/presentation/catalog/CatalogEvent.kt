package com.orglegal.fam.features.catalog.presentation.catalog

sealed class CatalogEvent {
    object FetchCatalog : CatalogEvent()
    object FetchAbout : CatalogEvent()
}
