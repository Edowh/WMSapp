// RestockAlertScreen.kt
package com.hs.wmsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hs.wmsapp.data.model.Product
import com.hs.wmsapp.data.repository.ProductRepository

@Composable
fun RestockAlertScreen(productRepository: ProductRepository) {
    // 使用 mutableStateListOf 代替 mutableStateOf
    val products = remember { mutableStateListOf<Product>().apply { addAll(productRepository.getLowStockProducts()) } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "补货提醒", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        if (products.isEmpty()) {
            Text(
                text = "所有产品库存充足",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(products) { product ->
                    RestockAlertItem(product = product)
                }
            }
        }
    }
}

@Composable
fun RestockAlertItem(product: Product) {
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
            Text(text = "库存数量: ${product.stockQuantity}", color = MaterialTheme.colors.error)
        }
    }
}
