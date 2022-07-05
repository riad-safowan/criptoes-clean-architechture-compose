package com.riadsafowan.cryptoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.riadsafowan.cryptoes.presentation.Screen
import com.riadsafowan.cryptoes.presentation.coin_details.CoinDetailScreen
import com.riadsafowan.cryptoes.presentation.coin_list.CoinListScreen
import com.riadsafowan.cryptoes.presentation.ui.theme.CryptoesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {
                composable(route = Screen.CoinListScreen.route){
                    CoinListScreen(navController = navController)
                }
                composable(route = Screen.CoinDetailScreen.route+"/{coinId}"){
                    CoinDetailScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoesTheme {
        Greeting("Android")
    }
}