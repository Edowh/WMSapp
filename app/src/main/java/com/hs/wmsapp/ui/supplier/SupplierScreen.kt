// SupplierScreen.kt
package com.hs.wmsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hs.wmsapp.data.model.Supplier
import com.hs.wmsapp.data.repository.SupplierRepository

@Composable
fun SupplierScreen(navController: NavController, supplierRepository: SupplierRepository) {
    // 修复状态声明，明确类型为 List<Supplier>
    val suppliers by remember { mutableStateOf(supplierRepository.getAllSuppliers()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "供应商管理", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        if (suppliers.isEmpty()) {
            Text(text = "暂无供应商信息", style = MaterialTheme.typography.body1)
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(suppliers) { supplier ->
                    SupplierItem(supplier = supplier, navController = navController)
                }
            }
        }
    }
}

@Composable
fun SupplierItem(supplier: Supplier, navController: NavController) {
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
            Text(text = "供应商名称: ${supplier.name}", style = MaterialTheme.typography.h6)
            Text(text = "联系方式: ${supplier.contactInfo}")
            Text(text = "地址: ${supplier.address}")

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                navController.navigate("supplierDetail/${supplier.id}")
            }) {
                Text(text = "查看详情")
            }
        }
    }
}
