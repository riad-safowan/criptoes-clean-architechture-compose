package com.riadsafowan.cryptoes.presentation.coin_list

import com.riadsafowan.cryptoes.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
