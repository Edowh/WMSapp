// InventoryScreen.kt
package com.hs.wmsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hs.wmsapp.data.model.Product
import com.hs.wmsapp.data.repository.ProductRepository

@Composable
fun InventoryScreen(productRepository: ProductRepository) {
    val products by remember { mutableStateOf(productRepository.getAllProducts()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "库存管理", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(products) { product ->
                InventoryItem(product = product)
            }
        }
    }
}

@Composable
fun InventoryItem(product: Product) {
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
            Text(text = "产品名称: ${product.name}", style = MaterialTheme.typography.h6)
            Text(text = "库存数量: ${product.quantity}")
            Text(text = "价格: ${product.price}")
        }
    }
}