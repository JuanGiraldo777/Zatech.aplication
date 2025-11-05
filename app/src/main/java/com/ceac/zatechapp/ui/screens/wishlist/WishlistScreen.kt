package com.ceac.zatechapp.ui.screens.wishlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceac.zatechapp.ui.screens.home.AppBottomBarVisual


@Composable
fun WishlistScreenVisual() {

    // Scaffold proporciona la estructura básica, especialmente para la Bottom Bar
    Scaffold(
        bottomBar = { AppBottomBarVisual() }, // Añade la barra de navegación inferior
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues) // Respeta el espacio de la Bottom Bar
                    .verticalScroll(rememberScrollState()) // Permite el desplazamiento vertical
            ) {

                TextTop()

                Spacer(modifier = Modifier.height(10.dp))

                // 1. Barra Superior (Búsqueda)

                TopSearchWishlist(
                    icon = Icons.Default.Search,
                    placeholder = "Search"
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Espacio extra al final para asegurar que el último producto no quede pegado al Bottom Bar
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    )

}

@Composable
fun TextTop() {
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Lista de deseos",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))


    }
}

@Composable
fun TopSearchWishlist(
    icon: Any, // Puede ser un ImageVector (para Icons.Default) o un Painter (para imágenes drawable)
    placeholder: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(top = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // 1. Campo de Búsqueda
        Surface(
            modifier = Modifier
                .width(280.dp)
                .height(56.dp),
            color = Color(0xFFEEEBEB),
            shape = RoundedCornerShape(12.dp)
        ) {
            // Organiza el icono y el texto horizontalmente
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp), // Espaciado interno
                verticalAlignment = Alignment.CenterVertically // Centra verticalmente los elementos
            ) {
                // Elemento visual
                when (icon) {
                    is ImageVector -> {
                        Icon(
                            imageVector = icon, // Usa el icono pasado como parámetro
                            contentDescription = null,
                            tint = Color.Gray, // Color del icono (gris oscuro)
                            modifier = Modifier.size(24.dp)
                        )
                    }

                }

                Spacer(modifier = Modifier.width(16.dp))

                //  El texto guía
                Text(
                    text = placeholder,
                    color = Color.Gray, // Color del texto (gris oscuro)
                    style = MaterialTheme.typography.titleMedium
                )

                // NOTA: Para un campo de texto real, reemplazar 'Text' por 'BasicTextField'
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWishlistScreenVisual() {

    WishlistScreenVisual()

}