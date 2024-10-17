// Order.kt
package com.hs.wmsapp.data.model

import java.io.Serializable
import java.util.Date

data class Order(
    val id: String,
    val supplierName: String, // 添加供应商名称
    val orderNumber: String,
    val quantity: Int,
    val isInbound: Boolean,
    val orderDate: Date,
    val customerName: String, // 添加客户名称属性
    val customerId: String,
    val totalAmount: Double,
    val status: String
) : Serializable