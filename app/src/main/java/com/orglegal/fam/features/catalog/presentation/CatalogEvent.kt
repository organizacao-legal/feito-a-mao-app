package com.orglegal.fam.features.catalog.presentation

sealed class CatalogEvent {
    object FetchCatalog : CatalogEvent()
    object FetchAbout : CatalogEvent()
}
