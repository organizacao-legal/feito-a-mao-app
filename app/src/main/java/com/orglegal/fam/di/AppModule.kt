package com.orglegal.fam.di

import com.orglegal.fam.features.catalog.data.remote.CatalogApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "http://192.168.0.102:3000/"

    @Provides
    @Singleton
    fun provideCatalogApi(): CatalogApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CatalogApi::class.java)
    }

}