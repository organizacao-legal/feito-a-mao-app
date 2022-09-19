package com.orglegal.fam.features.catalog.data.dto

import com.google.gson.annotations.SerializedName
import com.orglegal.fam.features.catalog.domain.model.Image

data class ImageDTO(
    val id: String,
    @SerializedName("path") val imageUrl: String,
    @SerializedName("description") val contentDescription: String
)

fun ImageDTO.toImage() : Image {
    return Image(
        id = id,
        imageUrl = imageUrl,
        contentDescription = contentDescription
    )
}