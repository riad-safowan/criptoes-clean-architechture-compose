package com.riadsafowan.cryptoes.domain.use_cases.get_coin

import com.riadsafowan.cryptoes.common.Resource
import com.riadsafowan.cryptoes.data.remote.dto.toCoinDetail
import com.riadsafowan.cryptoes.domain.models.CoinDetail
import com.riadsafowan.cryptoes.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success(coin.toCoinDetail()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}