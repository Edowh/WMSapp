// OrderRepository.kt
package com.hs.wmsapp.data.repository

import com.hs.wmsapp.data.model.Order

class OrderRepository {

    private val orders = mutableListOf<Order>()

    fun addOrder(order: Order) {
        orders.add(order)
    }

    fun getOrderById(id: String): Order? {
        return orders.find { it.id == id }
    }

    fun getAllOrders(): List<Order> {
        return orders
    }

    fun updateOrder(updatedOrder: Order) {
        val index = orders.indexOfFirst { it.id == updatedOrder.id }
        if (index != -1) {
            orders[index] = updatedOrder
        }
    }

    fun deleteOrder(id: String) {
        orders.removeAll { it.id == id }
    }

    fun getInboundOrders(): List<Order> {
        return orders.filter { it.isInbound }
    }
    
    fun getOutboundOrders(): List<Order> {
        return orders.filter { !it.isInbound }
    }

}