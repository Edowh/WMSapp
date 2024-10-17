package com.hs.wmsapp.ui.components

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.hs.wmsapp.R

// 定义 BottomNavItem 数据类
sealed class BottomNavItem(
    val title: String,
    val icon: Int,
    val route: String
) {
    object Home : BottomNavItem(
        title = "Products",
        icon = R.drawable.product_info_icon,
        route = "products"
    )

    object Orders : BottomNavItem(
        title = "Orders",
        icon = R.drawable.order_management_icon,
        route = "orders"
    )

    object Inventory : BottomNavItem(
        title = "Inventory",
        icon = R.drawable.inventory_icon,
        route = "inventory"
    )

    object Customers : BottomNavItem(
        title = "Customers",
        icon = R.drawable.customer_info_icon,
        route = "customers"
    )

    object Suppliers : BottomNavItem(
        title = "Suppliers",
        icon = R.drawable.supplier_info_icon,
        route = "suppliers"
    )
}

// 在导航栏中使用的 BottomNavItem 项列表
val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Orders,
    BottomNavItem.Inventory,
    BottomNavItem.Customers,
    BottomNavItem.Suppliers
)