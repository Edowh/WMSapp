// TopBar.kt
package com.hs.wmsapp.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.hs.wmsapp.R

@Composable
fun TopBar(title: String, onNavigationIconClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = title, color = Color.White)
        },
        navigationIcon = {
            IconButton(onClick = { onNavigationIconClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.menu_icon),
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        },
        backgroundColor = Color(0xFF6200EE),
        contentColor = Color.White
    )
}