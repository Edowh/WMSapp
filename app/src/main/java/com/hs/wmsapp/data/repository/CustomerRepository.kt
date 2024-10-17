// CustomerRepository.kt
package com.hs.wmsapp.data.repository

import com.hs.wmsapp.data.model.Customer

class CustomerRepository {

    private val customers = mutableListOf<Customer>()

    // 添加客户
    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    // 根据ID获取客户
    fun getCustomerById(id: String): Customer? {
        return customers.find { it.id == id }
    }

    // 获取所有客户
    fun getAllCustomers(): List<Customer> {
        return customers.toList()
    }

    // 更新客户信息
    fun updateCustomer(updatedCustomer: Customer) {
        val index = customers.indexOfFirst { it.id == updatedCustomer.id }
        if (index != -1) {
            customers[index] = updatedCustomer
        }
    }

    // 删除客户
    fun deleteCustomer(id: String) {
        customers.removeAll { it.id == id }
    }
}
