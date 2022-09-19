package com.orglegal.fam.features.catalog.domain.repository

import com.orglegal.fam.features.catalog.domain.model.About
import com.orglegal.fam.features.catalog.domain.model.Catalog
import com.orglegal.fam.util.Resource

interface CatalogRepository {

    suspend fun getCatalog() : Resource<Catalog>

    suspend fun getAbout() : Resource<About>
}