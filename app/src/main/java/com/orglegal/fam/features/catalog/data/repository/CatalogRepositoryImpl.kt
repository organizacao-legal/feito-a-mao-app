package com.orglegal.fam.features.catalog.data.repository

import com.orglegal.fam.features.catalog.data.dto.toAbout
import com.orglegal.fam.features.catalog.data.dto.toCatalog
import com.orglegal.fam.features.catalog.data.remote.CatalogApi
import com.orglegal.fam.features.catalog.domain.model.About
import com.orglegal.fam.features.catalog.domain.model.Catalog
import com.orglegal.fam.features.catalog.domain.repository.CatalogRepository
import com.orglegal.fam.util.Resource
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    private val api: CatalogApi
) : CatalogRepository {

    override suspend fun getCatalog(): Resource<Catalog> {
        return try {
            val response = api.getCatalog()
            val result = response.body()?.toCatalog()

            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "There was an unexpected error")
        }
    }

    override suspend fun getAbout(): Resource<About> {
        return try { val response = api.getConsts()
            val result = response.body()?.about?.toAbout()

            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "There was an unexpected error")
        }
    }
}