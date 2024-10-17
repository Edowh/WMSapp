// Customer.kt
package com.hs.wmsapp.data.model

import java.io.Serializable

data class Customer(
    val id: String,
    val name: String,
    val address: String,
    val contactNumber: String,
    val contactInfo: String,
    val email: String,
    val orderHistory: List<Order>
) : Serializable