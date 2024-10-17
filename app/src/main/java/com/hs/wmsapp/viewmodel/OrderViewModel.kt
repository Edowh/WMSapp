// OrderViewModel.kt
package com.hs.wmsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hs.wmsapp.data.model.Order
import com.hs.wmsapp.data.repository.OrderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrderViewModel(private val orderRepository: OrderRepository) : ViewModel() {

    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders

    init {
        getAllOrders()
    }

    private fun getAllOrders() {
        viewModelScope.launch {
            val fetchedOrders = orderRepository.getAllOrders()
            _orders.value = fetchedOrders
        }
    }

    fun addOrder(order: Order) {
        viewModelScope.launch {
            orderRepository.addOrder(order)
            getAllOrders() // Refresh the list after adding
        }
    }

    fun deleteOrder(orderId: String) {
        viewModelScope.launch {
            orderRepository.deleteOrder(orderId)
            getAllOrders() // Refresh the list after deletion
        }
    }

    fun updateOrder(order: Order) {
        viewModelScope.launch {
            orderRepository.updateOrder(order)
            getAllOrders() // Refresh the list after update
        }
    }
}
