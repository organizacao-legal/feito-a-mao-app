package com.orglegal.fam.features.catalog.data.dto

import com.google.gson.annotations.SerializedName
import com.orglegal.fam.features.catalog.domain.model.Category

data class CategoryDTO(
    @SerializedName("category_name") val name: String,
    val images: List<ImageDTO>
)

fun CategoryDTO.toCategory() : Category {
    return Category(
        name = name,
        images = images.map { it.toImage() }
    )
}