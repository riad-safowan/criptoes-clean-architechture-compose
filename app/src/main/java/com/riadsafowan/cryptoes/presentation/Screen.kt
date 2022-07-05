package com.riadsafowan.cryptoes.presentation

sealed class Screen (val route: String){
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_Detail_screen")
}