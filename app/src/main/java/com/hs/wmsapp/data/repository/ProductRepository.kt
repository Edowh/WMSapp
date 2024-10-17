package com.hs.wmsapp.data.repository

import com.hs.wmsapp.data.model.Product

class ProductRepository {

    private val products = mutableListOf<Product>()

    // 添加新产品
    fun addProduct(product: Product) {
        products.add(product)
    }

    // 根据 ID 获取产品
    fun getProductById(id: String): Product? {
        return products.find { it.id == id }
    }

    // 获取所有产品
    fun getAllProducts(): List<Product> {
        return products
    }

    // 登录验证
    fun login(username: String, password: String): Boolean {
        // 这里可以添加实际的登录逻辑，例如检查用户名和密码
        // 这是一个示例，您可以根据需要进行修改
        return username == "admin" && password == "password" // 示例验证
    }

    // 更新产品信息
    fun updateProduct(updatedProduct: Product) {
        val index = products.indexOfFirst { it.id == updatedProduct.id }
        if (index != -1) {
            products[index] = updatedProduct
        }
    }

    // 删除产品
    fun deleteProduct(id: String) {
        products.removeAll { it.id == id }
    }

    // 获取低库存产品列表
    fun getLowStockProducts(): List<Product> {
        return products.filter { it.stockQuantity < LOW_STOCK_THRESHOLD }
    }

    companion object {
        // 低库存阈值，可以根据需求调整
        const val LOW_STOCK_THRESHOLD = 10
    }
}
