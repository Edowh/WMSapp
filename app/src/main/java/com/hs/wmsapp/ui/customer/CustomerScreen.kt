// CustomerScreen.kt
package com.hs.wmsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hs.wmsapp.data.model.Customer
import com.hs.wmsapp.data.repository.CustomerRepository

@Composable
fun CustomerScreen(customerRepository: CustomerRepository) {
    // 使用 mutableStateListOf 以便 Jetpack Compose 能够正确追踪列表的更改
    val customers = remember { mutableStateListOf<Customer>().apply { addAll(customerRepository.getAllCustomers()) } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "客户管理", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        if (customers.isEmpty()) {
            Text(text = "当前没有客户信息", style = MaterialTheme.typography.body1)
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(customers) { customer ->
                    CustomerItem(customer = customer)
                }
            }
        }
    }
}

@Composable
fun CustomerItem(customer: Customer) {
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
            Text(text = "客户名称: ${customer.name}", style = MaterialTheme.typography.h6)
            Text(text = "联系方式: ${customer.contactInfo}")
            Text(text = "地址: ${customer.address}")
        }
    }
}
