package com.riadsafowan.cryptoes.di

import com.riadsafowan.cryptoes.common.Constants
import com.riadsafowan.cryptoes.data.remote.CoinPaprikaApiClient
import com.riadsafowan.cryptoes.data.repositories.CoinRepositoryImpl
import com.riadsafowan.cryptoes.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providePaprikaApiClient(): CoinPaprikaApiClient {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApiClient): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}