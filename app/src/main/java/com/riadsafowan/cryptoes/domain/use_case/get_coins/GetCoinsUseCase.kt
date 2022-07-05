package com.riadsafowan.cryptoes.domain.use_case.get_coins

import com.riadsafowan.cryptoes.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
}