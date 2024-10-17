// ExportScreen.kt
package com.hs.wmsapp.ui.export

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hs.wmsapp.data.model.ExportRecord
import com.hs.wmsapp.data.repository.ExportRepository

@Composable
fun ExportScreen(exportRepository: ExportRepository) {
    // 指定 customers 的类型为 List<ExportRecord>
    val exportRecords by remember { mutableStateOf(exportRepository.getExportRecords()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "导出记录", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            // items 函数使用 List<ExportRecord> 类型
            items(exportRecords) { record ->
                ExportItem(exportRecord = record)
            }
        }
    }
}

@Composable
fun ExportItem(exportRecord: ExportRecord) {
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
            Text(text = "记录编号: ${exportRecord.id}", style = MaterialTheme.typography.h6)
            Text(text = "日期: ${exportRecord.date}")
            Text(text = "产品数量: ${exportRecord.productCount}")
        }
    }
}
