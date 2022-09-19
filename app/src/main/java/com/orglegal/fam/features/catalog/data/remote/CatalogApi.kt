package com.orglegal.fam.features.catalog.data.remote

import com.orglegal.fam.features.catalog.data.dto.AboutResult
import com.orglegal.fam.features.catalog.data.dto.CatalogDTO
import retrofit2.Response
import retrofit2.http.GET

interface CatalogApi {

    @GET("catalog")
    suspend fun getCatalog() : Response<CatalogDTO>

    @GET("consts")
    suspend fun getConsts() : Response<AboutResult>
}