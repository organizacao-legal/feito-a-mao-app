package com.orglegal.fam.features.catalog.data.dto

import com.orglegal.fam.features.catalog.domain.model.Social
import com.orglegal.fam.features.catalog.utils.Socials

data class SocialDTO(
    val host: String,
    val url: String
)

fun SocialDTO.toSocial(): Social {
    return Social(
        host = host,
        url = url,
        type = mapSocial(host)
    )
}

private fun mapSocial(host: String) : Socials {
    return when (host) {
        Socials.INSTAGRAM.value -> {
            Socials.INSTAGRAM
        }
        Socials.WHATSAPP.value -> {
            Socials.WHATSAPP
        }
        else -> Socials.NULL
    }
}
