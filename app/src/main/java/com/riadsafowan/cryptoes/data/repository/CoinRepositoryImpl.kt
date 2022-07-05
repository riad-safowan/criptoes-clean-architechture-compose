package com.riadsafowan.cryptoes.data.repository

import com.riadsafowan.cryptoes.data.remote.CoinPaprikaApiClient
import com.riadsafowan.cryptoes.data.remote.dto.CoinDTO
import com.riadsafowan.cryptoes.data.remote.dto.CoinDetailDTO
import com.riadsafowan.cryptoes.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApiClient) :
    CoinRepository {
    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }
}