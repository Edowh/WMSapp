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
fun InboundOrderScreen(orderRepository: OrderRepository) {
    // 显式地定义 inboundOrders 的类型，确保类型推断正确
    val inboundOrders: List<Order> by remember { mutableStateOf(orderRepository.getInboundOrders()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "入库订单", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        if (inboundOrders.isEmpty()) {
            Text(text = "没有待处理的入库订单", style = MaterialTheme.typography.body1)
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(inboundOrders) { order ->
                    InboundOrderItem(order = order)
                }
            }
        }
    }
}

@Composable
fun InboundOrderItem(order: Order) {
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
            Text(text = "订单号: ${order.id}", style = MaterialTheme.typography.h6)
            Text(text = "供应商: ${order.supplierName}") // 确保 Order 数据类有 supplierName 属性
            Text(text = "数量: ${order.quantity}")
        }
    }
}
