// CustomerDetailScreen.kt
package com.hs.wmsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hs.wmsapp.data.model.Customer
import com.hs.wmsapp.data.repository.CustomerRepository

@Composable
fun CustomerDetailScreen(navController: NavController, customerId: String, customerRepository: CustomerRepository) {
    val customer by remember { mutableStateOf(customerRepository.getCustomerById(customerId)) }

    customer?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "客户详情", style = MaterialTheme.typography.h4)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "客户名称: ${it.name}", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "联系方式: ${it.contactInfo}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "地址: ${it.address}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "订单历史:", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))

            it.orderHistory.forEach { order ->
                Text(text = "- 订单编号: ${order.id}, 总额: ${order.totalAmount}, 状态: ${order.status}")
                Spacer(modifier = Modifier.height(4.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text(text = "返回")
            }
        }
    } ?: run {
        Text(text = "未找到客户信息", style = MaterialTheme.typography.h6)
    }
}