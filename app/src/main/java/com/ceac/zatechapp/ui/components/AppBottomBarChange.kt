package com.ceac.zatechapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.ceac.zatechapp.ui.theme.BackgroundWhite


@Composable
fun AppBottomBarChange(
    selectedItem: String,
    containerColor: Color
) {

    BottomAppBar(
        containerColor = Color.White,
        modifier = Modifier.height(60.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Iconos de navegación
            BottomNavItemChange(icon = Icons.Default.Home, label = "Home", isSelected = selectedItem == "Home")

            BottomNavItemChange(icon = Icons.Default.ChatBubble, label = "Chat", isSelected = selectedItem == "Chat")

            // Espacio para el FAB central
            Spacer(modifier = Modifier.width(64.dp))

            BottomNavItemChange(icon = Icons.Default.Favorite, label = "WishList", isSelected = selectedItem == "WishList")

            BottomNavItemChange(icon = Icons.Default.Person, label = "Profile", isSelected = selectedItem == "Profile")
        }
    }
    // El FAB se superpone encima del BottomAppBar, necesita un Box o similar para posicionarse
    // pero aquí lo pondremos simple para la maquetación.

    // FAB de la Cesta
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-40).dp), // Subir el FAB
        contentAlignment = Alignment.Center
    ) {
        val roundedCornerGlobal = 70.dp
        FloatingActionButton(
            onClick = { /* Acción de la Cesta */ },
            containerColor = Color.Red,
            shape = CircleShape,
            modifier = Modifier
                .size(60.dp)
                .dropShadow(
                    shape = RoundedCornerShape(roundedCornerGlobal),
                    shadow = Shadow(
                        radius = 7.dp,
                        spread = 5.dp,
                        color = Color(0x69BA2B2B),
                        offset = DpOffset(x = 0.dp, 8.dp)
                    )
                )

        ) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = Color.White)
        }
    }
}

@Composable
fun RowScope.BottomNavItemChange(icon: ImageVector, label: String, isSelected: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.weight(1f)) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) Color.Red else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(
    heightDp = 150,
    showBackground = true)
@Composable
fun PreviewHomeScreenVisual() {
    MaterialTheme(
        colorScheme = lightColorScheme(

            background = BackgroundWhite
        )
    ) {
        AppBottomBarChange(
            selectedItem = "Profile",
            containerColor = Color.Red
        )}
}