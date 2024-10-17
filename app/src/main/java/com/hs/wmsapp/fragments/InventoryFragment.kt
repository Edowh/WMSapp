// InventoryFragment.kt
package com.hs.wmsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hs.wmsapp.R
import com.hs.wmsapp.adapters.ProductAdapter
import com.hs.wmsapp.data.repository.ProductRepository
import com.hs.wmsapp.models.Product

class InventoryFragment : Fragment() {

    private lateinit var productRepository: ProductRepository
    private lateinit var productAdapter: ProductAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_inventory, container, false)

        // Initialize the RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView_inventory)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize ProductRepository and ProductAdapter
        productRepository = ProductRepository()
        productAdapter = ProductAdapter(productRepository.getAllProducts() as MutableList<Product>)
        recyclerView.adapter = productAdapter

        return view
    }
}
