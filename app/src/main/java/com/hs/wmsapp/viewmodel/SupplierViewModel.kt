package com.hs.wmsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hs.wmsapp.data.model.Supplier
import com.hs.wmsapp.data.repository.SupplierRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SupplierViewModel(private val supplierRepository: SupplierRepository) : ViewModel() {

    private val _suppliers = MutableStateFlow<List<Supplier>>(emptyList())
    val suppliers: StateFlow<List<Supplier>> = _suppliers

    init {
        getAllSuppliers()
    }

    private fun getAllSuppliers() {
        viewModelScope.launch {
            val fetchedSuppliers = supplierRepository.getAllSuppliers()
            _suppliers.value = fetchedSuppliers
        }
    }

    fun addSupplier(supplier: Supplier) {
        viewModelScope.launch {
            supplierRepository.addSupplier(supplier)
            getAllSuppliers() // Refresh the list after adding
        }
    }

    fun deleteSupplier(supplierId: String) {
        viewModelScope.launch {
            supplierRepository.deleteSupplier(supplierId)
            getAllSuppliers() // Refresh the list after deletion
        }
    }

    fun updateSupplier(supplier: Supplier) {
        viewModelScope.launch {
            supplierRepository.updateSupplier(supplier)
            getAllSuppliers() // Refresh the list after update
        }
    }
}
