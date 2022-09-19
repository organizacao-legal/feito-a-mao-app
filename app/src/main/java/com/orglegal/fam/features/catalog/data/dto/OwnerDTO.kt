package com.orglegal.fam.features.catalog.data.dto

import com.google.gson.annotations.SerializedName
import com.orglegal.fam.features.catalog.domain.model.Owner

data class OwnerDTO(
    val name: String,
    val biography: String,
    @SerializedName("image_url") val imageUrl: String
)

fun OwnerDTO.toOwner() : Owner {
    return Owner(
        name = name,
        biography = biography,
        imageUrl = imageUrl
    )
}