package com.hs.wmsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hs.wmsapp.data.model.Product
import com.hs.wmsapp.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch {
            val fetchedProducts = productRepository.getAllProducts()
            _products.value = fetchedProducts
        }
    }

    fun addProduct(product: Product) {
        viewModelScope.launch {
            productRepository.addProduct(product)
            getAllProducts() // Refresh the list after adding
        }
    }

    fun deleteProduct(productId: String) {
        viewModelScope.launch {
            productRepository.deleteProduct(productId)
            getAllProducts() // Refresh the list after deletion
        }
    }

    fun updateProduct(product: Product) {
        viewModelScope.launch {
            productRepository.updateProduct(product)
            getAllProducts() // Refresh the list after update
        }
    }
}
