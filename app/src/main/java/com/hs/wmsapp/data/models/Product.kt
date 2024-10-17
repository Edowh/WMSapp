// Product.kt
package com.hs.wmsapp.data.model

import java.io.Serializable

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val supplierId: String,
    val stockQuantity: Int
) : Serializable