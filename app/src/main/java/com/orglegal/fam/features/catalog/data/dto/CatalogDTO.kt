package com.orglegal.fam.features.catalog.data.dto

import com.orglegal.fam.features.catalog.domain.model.Catalog

data class CatalogDTO(
    val catalog: List<CategoryDTO>
)

fun CatalogDTO.toCatalog() : Catalog {
    return Catalog(
        catalog = catalog.map { it.toCategory() }
    )
}
