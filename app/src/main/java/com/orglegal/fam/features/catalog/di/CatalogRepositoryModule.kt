package com.orglegal.fam.features.catalog.di

import com.orglegal.fam.features.catalog.data.repository.CatalogRepositoryImpl
import com.orglegal.fam.features.catalog.domain.repository.CatalogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CatalogRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCatalogRepository(
        catalogRepositoryImpl: CatalogRepositoryImpl
    ) : CatalogRepository
}