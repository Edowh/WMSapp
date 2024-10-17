// Theme.kt
package com.hs.wmsapp.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 定义自定义颜色
val PrimaryColor = Color(0xFF6200EA)
val PrimaryLightColor = Color(0xFFBB86FC)
val PrimaryDarkColor = Color(0xFF3700B3)
val SecondaryColor = Color(0xFF03DAC5)

// 定义自定义排版
val CustomTypography = Typography(
    h4 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

// 定义自定义形状
val CustomShapes = Shapes(
    small = androidx.compose.foundation.shape.RoundedCornerShape(4.dp),
    medium = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
    large = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
)

// 定义主题
@Composable
fun WMSAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(
            primary = PrimaryColor,
            primaryVariant = PrimaryDarkColor,
            secondary = SecondaryColor
        ),
        typography = CustomTypography,
        shapes = CustomShapes,
        content = content
    )
}
