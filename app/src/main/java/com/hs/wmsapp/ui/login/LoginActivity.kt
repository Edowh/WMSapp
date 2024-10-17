package com.hs.wmsapp.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hs.wmsapp.data.repository.ProductRepository
import com.hs.wmsapp.ui.screens.LoginScreen
import com.hs.wmsapp.ui.screens.RegisterScreen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val productRepository = ProductRepository() // 创建 ProductRepository 实例

            NavHost(navController = navController, startDestination = "login") {
                composable("login") { LoginScreen(navController, productRepository) }
                composable("register") { RegisterScreen(navController) }
            }
        }
    }
}
