package com.orglegal.fam.features.catalog.data.dto

import com.orglegal.fam.features.catalog.domain.model.About

data class AboutDTO(
    val owner: OwnerDTO,
    val socials: List<SocialDTO>
)

fun AboutDTO.toAbout() : About {
    return About(
        owner = this.owner.toOwner(),
        socials = this.socials.toSocials()
    )
}