package com.orglegal.fam.features.catalog.domain.model

import com.orglegal.fam.features.catalog.utils.Socials

data class About(
    val owner: Owner,
    val socials: List<Social>
)

val mockedAbout = About(
    Owner(
        name = "Lorem ipsum",
        biography = "Lorem ipsum dolor sit amet, sed do eiusmod tempor incididunt ut abore et dolore magna aliqua. Lorem ipsum dolor sit amet.",
        imageUrl = "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
    ),
    socials = listOf(
        Social(
            host = "instagram",
            url = "http://instagram.com",
            type = Socials.INSTAGRAM
        ),
        Social(
            host = "whatsapp",
            url = "http://whatsapp.com",
            type = Socials.WHATSAPP
        ),
        Social(
            host = "tiktok",
            url = "http://tiktok.com",
            type = Socials.TIKTOK
        ),
        Social(
            host = "tiktok",
            url = "http://tiktok.com",
            type = Socials.NULL
        )
    )
)