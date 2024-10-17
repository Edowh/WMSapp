// LoginScreen.kt
package com.hs.wmsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hs.wmsapp.data.repository.ProductRepository

@Composable
fun LoginScreen(navController: NavController, productRepository: ProductRepository) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "登录", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("用户名") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("密码") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colors.error)
        }

        Button(
            onClick = {
                if (username.isEmpty() || password.isEmpty()) {
                    errorMessage = "用户名和密码不能为空"
                } else {
                    println("Attempting to login with username: \$username and password: \$password") // 调试输出
                    try {
                        val isValidUser = productRepository.login(username, password)
                        if (isValidUser) {
                            errorMessage = ""
                            navController.navigate("inventory")
                        } else {
                            errorMessage = "用户名或密码错误"
                        }
                    } catch (e: Exception) {
                        errorMessage = "登录时发生错误，请重试"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "登录")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { navController.navigate("register") }) {
            Text(text = "还没有账号？立即注册")
        }
    }
}
