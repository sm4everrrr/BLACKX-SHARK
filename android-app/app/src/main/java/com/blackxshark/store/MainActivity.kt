package com.blackxshark.store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Ink = Color(0xFF090C12)
private val SurfaceDark = Color(0xFF151B25)
private val Blue = Color(0xFF4C8DFF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { BlackXApp() }
    }
}

data class StoreCategory(val title: String, val detail: String)
@Composable
fun BlackXApp() {
    val categories = listOf(
        StoreCategory("CARDS", "VISA · MASTERCARD · JCB · DISCOVER · AMEX"),
        StoreCategory("GIFT CARD", "Google Play gift cards"),
        StoreCategory("PRIME 8", "Explore available products"),
        StoreCategory("COURSES", "Digital learning products")
    )
    var selected by remember { mutableStateOf("Home") }
    MaterialTheme(colorScheme = darkColorScheme(
        primary = Blue, background = Ink, surface = SurfaceDark,
        onBackground = Color.White, onSurface = Color.White
    )) {
        Scaffold(containerColor = Ink, bottomBar = {
            NavigationBar(containerColor = SurfaceDark) {
                listOf("Home", "Categories", "Orders", "Profile").forEach { item ->
                    NavigationBarItem(
                        selected = selected == item,
                        onClick = { selected = item },
                        icon = {},
                        label = { Text(item) }
                    )
                }
            }
        }) { padding ->
            LazyColumn(Modifier.fillMaxSize().padding(padding).padding(horizontal = 20.dp)) {
                item {
                    Spacer(Modifier.height(28.dp))
                    Text("BLACKX SHARK", color = Blue, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(10.dp))
                    Text("Digital essentials.\nMade simple.", fontSize = 30.sp, lineHeight = 36.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(20.dp))
                    OutlinedTextField(value = "", onValueChange = {}, readOnly = true,
                        placeholder = { Text("Search products") }, modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp))
                    Spacer(Modifier.height(26.dp))
                    Text(if (selected == "Home") "Shop by category" else selected,
                        fontSize = 21.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.height(12.dp))
                }
                items(categories) { category ->
                    Column(
                        Modifier.fillMaxWidth().padding(bottom = 12.dp)
                            .background(SurfaceDark, RoundedCornerShape(16.dp))
                            .clickable { selected = category.title }.padding(18.dp)
                    ) {
                        Text(category.title, color = Color.White, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(6.dp))
                        Text(category.detail, color = Color.LightGray, fontSize = 12.sp)
                    }
                }
                item {
                    Text("Secure checkout", color = Blue, fontWeight = FontWeight.SemiBold)
                    Text("Payments are confirmed only after server-side or administrator verification.",
                        color = Color.LightGray, fontSize = 12.sp, modifier = Modifier.padding(top = 6.dp, bottom = 24.dp))
                }
            }
        }
    }
}
