// OutboundOrderScreen.kt
package com.hs.wmsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hs.wmsapp.data.model.Order
import com.hs.wmsapp.data.repository.OrderRepository

@Composable
fun OutboundOrderScreen(orderRepository: OrderRepository) {
    val outboundOrders by remember { mutableStateOf(orderRepository.getOutboundOrders()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "出库订单管理", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(outboundOrders) { order ->
                OutboundOrderItem(order = order)
            }
        }
    }
}

@Composable
fun OutboundOrderItem(order: Order) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "订单编号: ${order.id}", style = MaterialTheme.typography.h6)
            Text(text = "客户名称: ${order.customerName}")
            Text(text = "订单总额: ${order.totalAmount}")
            Text(text = "状态: ${order.status}")
        }
    }
}