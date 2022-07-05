package com.riadsafowan.cryptoes.domain.repository

import com.riadsafowan.cryptoes.data.remote.dto.CoinDTO
import com.riadsafowan.cryptoes.data.remote.dto.CoinDetailDTO

interface CoinRepository {
suspend fun getCoins():List<CoinDTO>
suspend fun getCoinById(coinId:String):CoinDetailDTO
}