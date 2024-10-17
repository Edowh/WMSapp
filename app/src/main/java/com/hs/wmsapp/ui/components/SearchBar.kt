// SearchBar.kt
package com.hs.wmsapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.hs.wmsapp.R

@Composable
fun SearchBar(hint: String, onSearch: (String) -> Unit) {
    val searchQuery = remember { mutableStateOf("") }

    BasicTextField(
        value = searchQuery.value,
        onValueChange = {
            searchQuery.value = it
            onSearch(it)
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.Black),
        decorationBox = { innerTextField ->
            IconButton(onClick = { /* Search action */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            }
            if (searchQuery.value.isEmpty()) {
                Text(text = hint, style = TextStyle(color = Color.Gray))
            }
            innerTextField()
        }
    )
}