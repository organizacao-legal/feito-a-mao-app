package com.orglegal.fam.features.catalog.domain.model

import com.orglegal.fam.features.catalog.utils.Socials

data class Social(
    val host: String,
    val url: String,
    val type: Socials
)
