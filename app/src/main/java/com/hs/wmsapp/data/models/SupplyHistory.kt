// SupplyHistory.kt
package com.hs.wmsapp.data.model

data class SupplyHistory(
    val id: String,           // 供货记录的唯一标识符
    val totalAmount: Double,  // 供货总金额
    val status: String        // 供货的状态，例如 "已完成" 或 "待发货"
)
