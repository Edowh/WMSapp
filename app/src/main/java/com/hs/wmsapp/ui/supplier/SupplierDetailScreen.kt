// SupplierDetailScreen.kt
package com.hs.wmsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hs.wmsapp.data.model.Supplier
import com.hs.wmsapp.data.repository.SupplierRepository

@Composable
fun SupplierDetailScreen(navController: NavController, supplierId: String, supplierRepository: SupplierRepository) {
    val supplier by remember { mutableStateOf(supplierRepository.getSupplierById(supplierId)) }

    supplier?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "供应商详情", style = MaterialTheme.typography.h4)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "供应商名称: ${it.name}", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "联系方式: ${it.contactInfo}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "地址: ${it.address}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "供货历史:", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))

            it.supplyHistory.forEach { supply ->
                Text(text = "- 供货编号: ${supply.id}, 总额: ${supply.totalAmount}, 状态: ${supply.status}")
                Spacer(modifier = Modifier.height(4.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text(text = "返回")
            }
        }
    } ?: run {
        Text(text = "未找到供应商信息", style = MaterialTheme.typography.h6)
    }
}