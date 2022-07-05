package com.riadsafowan.cryptoes.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.riadsafowan.cryptoes.common.Constants
import com.riadsafowan.cryptoes.common.Resource
import com.riadsafowan.cryptoes.domain.use_cases.get_coin.GetCoinUseCase
import com.riadsafowan.cryptoes.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { id ->
            getCoinDetail(id)
        }
    }

    private fun getCoinDetail(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coins = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        CoinDetailState(error = result.message ?: "Unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}