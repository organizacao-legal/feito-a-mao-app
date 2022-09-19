package com.orglegal.fam.features.catalog.data.remote

import com.orglegal.fam.features.catalog.data.dto.AboutDTO
import com.orglegal.fam.features.catalog.domain.model.About
import com.orglegal.fam.features.catalog.domain.model.Catalog
import retrofit2.Response
import retrofit2.http.GET

interface CatalogApi {

    @GET("catalog")
    suspend fun getCatalog() : Response<Catalog>

    @GET("consts")
    suspend fun getConsts() : Response<AboutDTO>
}