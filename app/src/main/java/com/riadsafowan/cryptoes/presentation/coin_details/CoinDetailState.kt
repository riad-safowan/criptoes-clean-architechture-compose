package com.riadsafowan.cryptoes.presentation.coin_details

import com.riadsafowan.cryptoes.domain.models.Coin
import com.riadsafowan.cryptoes.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coins: CoinDetail? = null,
    val error: String = ""
)
