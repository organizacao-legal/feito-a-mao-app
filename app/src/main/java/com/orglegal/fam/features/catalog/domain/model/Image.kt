package com.orglegal.fam.features.catalog.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val id: String,
    val imageUrl: String,
    val contentDescription: String
) : Parcelable
