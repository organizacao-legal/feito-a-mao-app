package com.orglegal.fam.features.catalog.data.dto

import com.orglegal.fam.features.catalog.domain.model.About

data class AboutDTO(
    val about: AboutBodyDTO
)

data class AboutBodyDTO(
    val owner: OwnerDTO,
    val socials: List<SocialDTO>
)

fun AboutBodyDTO.toAbout(): About {
    return About(
        owner = owner.toOwner(),
        socials = socials.map { it.toSocial() }
    )
}