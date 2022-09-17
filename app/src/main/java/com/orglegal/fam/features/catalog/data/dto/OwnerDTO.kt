package com.orglegal.fam.features.catalog.data.dto

import com.orglegal.fam.features.catalog.domain.model.Owner

data class OwnerDTO(
    val name: String,
    val biography: String,
    val imageUrl: String
)

fun OwnerDTO.toOwner() : Owner {
    return Owner(
        name = this.name,
        biography = this.biography,
        imageUrl = this.imageUrl
    )
}