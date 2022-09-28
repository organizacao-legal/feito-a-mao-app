package com.orglegal.fam.features.catalog.domain.model

import android.net.Uri
import android.os.Parcelable
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val name: String,
    val images: List<Image>
) : Parcelable

fun Category.toStringJson(): String {
    return Uri.encode(Gson().toJson(this))
}