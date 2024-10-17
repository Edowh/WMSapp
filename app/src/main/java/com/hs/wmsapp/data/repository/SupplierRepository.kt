// SupplierRepository.kt
package com.hs.wmsapp.data.repository

import com.hs.wmsapp.data.model.Supplier

class SupplierRepository {

    private val suppliers = mutableListOf<Supplier>()

    fun addSupplier(supplier: Supplier) {
        suppliers.add(supplier)
    }

    fun getSupplierById(id: String): Supplier? {
        return suppliers.find { it.id == id }
    }

    fun getAllSuppliers(): List<Supplier> {
        return suppliers
    }

    fun updateSupplier(updatedSupplier: Supplier) {
        val index = suppliers.indexOfFirst { it.id == updatedSupplier.id }
        if (index != -1) {
            suppliers[index] = updatedSupplier
        }
    }

    fun deleteSupplier(id: String) {
        suppliers.removeAll { it.id == id }
    }
}