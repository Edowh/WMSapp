// ExportRepository.kt
package com.hs.wmsapp.data.repository

import com.hs.wmsapp.data.model.ExportRecord

class ExportRepository {

    private val exportRecords = mutableListOf<ExportRecord>()

    init {
        // 添加一些示例记录，供测试使用
        exportRecords.add(ExportRecord(id = "EXP001", date = "2024-10-01", productCount = 10))
        exportRecords.add(ExportRecord(id = "EXP002", date = "2024-10-05", productCount = 20))
        exportRecords.add(ExportRecord(id = "EXP003", date = "2024-10-10", productCount = 15))
    }

    fun getExportRecords(): List<ExportRecord> {
        return exportRecords
    }

    fun addExportRecord(exportRecord: ExportRecord) {
        exportRecords.add(exportRecord)
    }

    fun getExportRecordById(id: String): ExportRecord? {
        return exportRecords.find { it.id == id }
    }

    fun updateExportRecord(updatedRecord: ExportRecord) {
        val index = exportRecords.indexOfFirst { it.id == updatedRecord.id }
        if (index != -1) {
            exportRecords[index] = updatedRecord
        }
    }

    fun deleteExportRecord(id: String) {
        exportRecords.removeAll { it.id == id }
    }
}
