package com.ceac.zatechapp.ui.screens.wishlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceac.zatechapp.R
import com.ceac.zatechapp.ui.components.AppBottomBarChange
import com.ceac.zatechapp.ui.theme.BackgroundWhite
import com.ceac.zatechapp.ui.theme.BlackPrimaryText
import com.ceac.zatechapp.ui.theme.PrimaryRed
import com.ceac.zatechapp.ui.theme.SecondaryGreen


@Composable
fun WishlistScreenVisual() {

    Scaffold(
        bottomBar = {
            AppBottomBarChange(

                selectedItem = "WishList",
                containerColor = Color.Red

            )
        },
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

                Spacer(modifier = Modifier.height(30.dp))

                //2. Cards de Productos

                CardsProduct(
                    productName = "Zapatillas para caminatas",
                    productPrice = "80,00 EUR",
                    image = R.drawable.zapatillas_botas
                )

                Spacer(modifier = Modifier.height(23.dp))

                CardsProduct(
                    productName = "Zapatillas Nike",
                    productPrice = "400,00 EUR",
                    image = R.drawable.zapatillas_nike
                )

                // Espacio extra al final para asegurar que el último producto no quede pegado al Bottom Bar
                Spacer(modifier = Modifier.height(80.dp))


            }
        }
    )

}

@Composable
fun TextTop() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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


@Composable
fun CardsProduct(
    productName: String,
    productPrice: String,
    image: Int
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE5E5E5)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        //ORGANIZADOR PRINCIPAL: Columna (arriba-abajo)
        Column(modifier = Modifier.padding(12.dp)) {

            //ORGANIZADOR CABECERA: Fila (izquierda-derecha)
            Row(
                modifier = Modifier.fillMaxWidth(),



                verticalAlignment = Alignment.CenterVertically
            ) {
                // Imagen circular del producto
                Image(

                    painter = painterResource(id = image),
                    contentDescription = productName,
                    modifier = Modifier
                        .size(70.dp)
                        .background(color = PrimaryRed, CircleShape)
                        .clip(CircleShape)
                        .border(2.dp, BlackPrimaryText, CircleShape) // borde rojo
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Columna con nombre y precio
                Column {
                    Text(
                        text = productName,
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = productPrice,
                        fontSize = 16.sp,
                        color = SecondaryGreen, // verde oscuro
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Icono eliminar
                IconButton(
                    onClick = {/* */ },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color(0xFFFFD3D3).copy(alpha = 1f)
                    ),
                    modifier = Modifier
                        .size(40.dp)

                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar",
                        tint = Color(0xFFE74C3C) // rojo
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Botón de añadir a la cesta
                Button(
                    onClick = {/* */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA553B)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "AÑADIR A LA CESTA",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 13.sp
                    )
                }
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