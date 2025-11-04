package com.ceac.zatechapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun CustomButtonCard() {
    val roundedCornerGlobal = 15.dp
    Box(modifier = Modifier) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .offset(y = (-30).dp) // Subir el FAB
                .dropShadow(
                    shape = RoundedCornerShape(roundedCornerGlobal),
                    shadow = Shadow(
                        radius = 4.dp,
                        spread = 1.dp,
                        color = Color(0x40000000),
                        offset = DpOffset(x = 0.dp, 4.dp),
                    )
                )
                .align (Alignment.Center)
        ) {
            FloatingActionButton(
                onClick = { /* Acción de la Cesta */ },
                containerColor = Color.Red,
                shape = CircleShape,
                modifier = Modifier.size(60.dp)
            ) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = Color.White)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewButtonCard() {
    CustomButtonCard()
}