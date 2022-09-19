package com.orglegal.fam.features.catalog.data.dto

import com.orglegal.fam.features.catalog.domain.model.About

data class AboutDTO(
    val owner: OwnerDTO,
    val socials: List<SocialDTO>
)

data class AboutResult(
    val about: AboutDTO
)

fun AboutDTO.toAbout() : About {
    return About(
        owner = owner.toOwner(),
        socials = socials.map { it.toSocial() }
    )
}