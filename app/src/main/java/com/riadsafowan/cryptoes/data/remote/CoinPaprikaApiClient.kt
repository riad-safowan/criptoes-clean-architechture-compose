package com.riadsafowan.cryptoes.data.remote

import com.riadsafowan.cryptoes.data.remote.dto.CoinDTO
import com.riadsafowan.cryptoes.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApiClient {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDTO

}