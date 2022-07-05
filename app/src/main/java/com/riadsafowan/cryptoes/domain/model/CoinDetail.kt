package com.riadsafowan.cryptoes.domain.model

import com.riadsafowan.cryptoes.data.remote.dto.CoinDetailDTO

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<CoinDetailDTO.TeamMember>
)
