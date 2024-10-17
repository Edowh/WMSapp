// CustomerViewModel.kt
package com.hs.wmsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hs.wmsapp.data.model.Customer
import com.hs.wmsapp.data.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomerViewModel(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    // State to hold the list of customers
    private val _customers = MutableStateFlow<List<Customer>>(emptyList())
    val customers: StateFlow<List<Customer>> get() = _customers

    init {
        loadCustomers()
    }

    // Function to load customers from repository
    private fun loadCustomers() {
        viewModelScope.launch {
            val customerList = customerRepository.getAllCustomers()
            _customers.value = customerList
        }
    }

    // Function to add a customer
    fun addCustomer(customer: Customer) {
        viewModelScope.launch {
            customerRepository.addCustomer(customer)
            loadCustomers() // Refresh the list after adding a customer
        }
    }

    // Function to delete a customer by id
    fun deleteCustomer(id: String) {
        viewModelScope.launch {
            customerRepository.deleteCustomer(id)
            loadCustomers() // Refresh the list after deleting a customer
        }
    }

    // Function to update an existing customer
    fun updateCustomer(updatedCustomer: Customer) {
        viewModelScope.launch {
            customerRepository.updateCustomer(updatedCustomer)
            loadCustomers() // Refresh the list after updating a customer
        }
    }
}
