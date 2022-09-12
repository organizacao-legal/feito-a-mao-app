package com.orglegal.fam.features.catalog.domain.model

data class Catalog(
    val catalog: List<Category>
)

val mockedCatalog = Catalog(
    catalog = listOf(
        Category(
            name = "Luvinhas",
            images = listOf(
                Image(
                    id = "1",
                    imageUrl = "https://images.unsplash.com/photo-1579455134319-042f718340a4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1176&q=80"
                )
            )
        )
    )
)
