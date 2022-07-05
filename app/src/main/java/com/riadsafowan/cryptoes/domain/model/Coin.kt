package com.riadsafowan.cryptoes.domain.model

import com.riadsafowan.cryptoes.data.remote.dto.CoinDTO

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

