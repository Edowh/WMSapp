// Supplier.kt
package com.hs.wmsapp.data.model

import java.io.Serializable

data class Supplier(
    val id: String,
    val name: String,
    val address: String,
    val contactInfo: String,
    val contactNumber: String,
    val email: String,
    val supplyHistory: List<SupplyHistory> = listOf()
) : Serializable