package com.ceac.zatechapp.ui.screens.wishlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceac.zatechapp.ui.screens.auth.ForgotPasswordLinkVisual
import com.ceac.zatechapp.ui.screens.auth.LoginButtonVisual
import com.ceac.zatechapp.ui.screens.auth.LoginFieldsVisual
import com.ceac.zatechapp.ui.screens.auth.LoginHeaderVisual
import com.ceac.zatechapp.ui.screens.auth.LoginIconsVisual
import com.ceac.zatechapp.ui.screens.auth.RegisterLinkVisual
import com.ceac.zatechapp.ui.screens.auth.ResetPasswordLinkVisual
import com.ceac.zatechapp.ui.screens.home.AppBottomBarVisual
import com.ceac.zatechapp.ui.theme.BackgroundWhite
import com.ceac.zatechapp.ui.theme.BlackPrimaryText


@Composable
fun WishlistScreenVisual() {

    Scaffold(
        bottomBar = { AppBottomBarVisual() },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 20.dp), // Márgenes laterales
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp)) // Espacio superior

                TextTop()


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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Lista de deseos",
            style = MaterialTheme.typography.headlineMedium,
            color = BlackPrimaryText,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(15.dp))


    }
}

@Composable
fun TopSearchWishlist(
    icon: Any, // Puede ser un ImageVector (para Icons.Default) o un Painter (para imágenes drawable)
    placeholder: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // 1. Campo de Búsqueda
        Surface(
            modifier = Modifier
                .width(400.dp)
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
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = BackgroundWhite
        )
    ) {
        WishlistScreenVisual()
    }

}