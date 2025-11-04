package com.ceac.zatechapp.ui.screens.wishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ceac.zatechapp.ui.screens.home.AppBottomBarVisual
import com.ceac.zatechapp.ui.screens.home.PopularProductsSectionVisual
import com.ceac.zatechapp.ui.screens.home.TopSearchBarVisual


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
                // El padding horizontal se aplica a los componentes internos para mayor control

                // 1. Barra Superior (Búsqueda y Notificaciones)
                TopSearchBarVisual(
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

