package com.ceac.zatechapp.ui.screens.home


import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceac.zatechapp.R
import com.ceac.zatechapp.ui.theme.GraySecondaryText


@Composable
fun HomeScreenVisual() {
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

                // 2. Banner de Promoción (20% OFF)
                PromotionBannerVisual()

                // 3. Fila de Categorías (Sneakers, Tech, etc.)
                CategoryRowVisual()
                Spacer(modifier = Modifier.height(1.dp))
                // 4. Recomendaciones (Carrusel horizontal)
                RecommendationsSectionVisual()
                Spacer(modifier = Modifier.height(20.dp))
                // 5. Productos Populares (Grid o Lista)
                PopularProductsSectionVisual()

                // Espacio extra al final para asegurar que el último producto no quede pegado al Bottom Bar
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    )
}


@Composable
fun TopSearchBarVisual(
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
                .height(56.dp), // Altura fija como un campo de entrada estándar
            // Color de fondo: Usamos un gris muy claro que simula el diseño de Figma
            color = Color(0xFFEEEBEB),
            // Forma: Esquinas redondeadas (por ejemplo, 12.dp)
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
                    // Usar Painter para imagen propia
                }

                Spacer(modifier = Modifier.width(16.dp)) // Espacio entre el icono y el texto

                //  El texto guía
                Text(
                    text = placeholder,
                    color = Color.Gray, // Color del texto (gris oscuro)
                    style = MaterialTheme.typography.titleMedium
                )

                // NOTA: Para un campo de texto real, reemplazar 'Text' por 'BasicTextField'
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        // 2. Botón de Notificación (circular y gris claro)
        IconButton(
            onClick = { /* Acción de Notificaciones */ },
            modifier = Modifier.size(50.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color(0xFFF0F0F0) // Fondo gris claro
            )
        ) {
            Icon(
                Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = Color.Gray
            )
        }
    }
}


val PromoOrange = Color(0xFFEA553B) // Naranja rojizo del banner

@Composable
fun PromotionBannerVisual() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp) // Altura fija para el banner
            .padding(horizontal = 24.dp),
        color = PromoOrange,
        shape = RoundedCornerShape(25.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Icono de descuento
            Image(
                painter = painterResource(id = R.drawable.descuento),
                contentDescription = "Logo de la App",
                modifier = Modifier.size(70.dp),
                contentScale = ContentScale.Fit
            )

            // Texto de la promoción
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "En tu primera\n      compra",
                    color = Color.Black,
                    fontSize = 10.sp
                )
                Text(
                    text = "RECIBE UN",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "20%",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )
        }
    }
}


@Composable
fun CategoryRowVisual() {
    Column(
        modifier = Modifier
            .padding(top = 24.dp, bottom = 24.dp)
            .padding(horizontal = 24.dp)
    ) {

        // Fila de iconos
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // 1. Sneakers
            CategoryItem(
                iconPainter = painterResource(id = R.drawable.sneakers), //
                iconText = "Sneakers"
            )

            // 2. Tech
            CategoryItem(
                iconPainter = painterResource(id = R.drawable.tech_category), //
                iconText = "Tech"
            )

            // 3. Tendencias
            CategoryItem(
                iconPainter = painterResource(id = R.drawable.tendencia), //
                iconText = "Tendencias"
            )

            // ️ 4. Ofertas & Reventas
            CategoryItem(
                iconPainter = painterResource(id = R.drawable.ventas_image), //
                iconText = "Ofertas &\nReventas" // Texto en dos líneas
            )

            // ️ 5. Estilo & Cultura
            CategoryItem(
                iconPainter = painterResource(id = R.drawable.estilo_y_cultura_image), //
                iconText = "Estilo &\nCultura" // Texto en dos líneas
            )
        }
    }
}

val ColorBase = Color(0xFFEA553B)
val ColorConOpacidad46 = ColorBase.copy(alpha = 0.46f) //PARA DARLE UNA OPACIDAD DEL 46%

// Item individual: Círculo gris claro con un texto debajo
@Composable
fun CategoryItem(iconPainter: Painter, iconText: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            modifier = Modifier.size(60.dp),
            shape = RoundedCornerShape(16.dp),
            color = ColorConOpacidad46,
            //Aqui iria la funcion de la sombra
        ) {

            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = iconPainter,
                    contentDescription = "Logo de la App",
                    modifier = Modifier.size(38.dp),
                    contentScale = ContentScale.Fit
                ) // Emoji como placeholder
            }

        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = iconText,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun RecommendationsSectionVisual() {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        // Título de la sección
        Text(
            text = "Recomendaciones de la semana",
            color = Color(0xFF595959),
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(bottom = 12.dp)
        )

        // LAZYROW: Contenedor para el scroll horizontal
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre las tarjetas
        ) {
            item {
                // Tarjeta de Móviles
                RecommendationCard(
                    title = "Móviles",
                    subtitle = "12 Marcas",
                    image = R.drawable.recomendations_1  // Placeholder de color para la imagen
                )
            }
            item {
                // Tarjeta de Moda
                RecommendationCard(
                    title = "Moda",
                    subtitle = "10 Marcas",
                    image = R.drawable.recomendations_2
                )
            }
            // Puedes añadir más items aquí si tu diseño tiene más secciones
        }
    }
}

// Componente de Tarjeta de Recomendación Individual
@Composable
fun RecommendationCard(
    title: String,
    subtitle: String,
    image: Int// Simulación de una imagen de fondo
) {
    // Definimos el tamaño y la forma de la tarjeta
    val cardWidth = 250.dp
    val cardHeight = 100.dp

    Card(
        modifier = Modifier
            .width(cardWidth)
            .height(cardHeight),
        shape = RoundedCornerShape(20.dp),

        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        // BOX: Usado para superponer el texto sobre el fondo/imagen
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = image),
                contentDescription = "Logo de la App",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            // Texto de la categoría alineado a la izquierda-inferior
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(8.dp)
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = subtitle,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }

    }
}

@Composable
fun PopularProductsSectionVisual() {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Productos Populares",
            color = Color(0xFF595959),
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // En lugar de LazyVerticalGrid, usaremos Column + Row con dos Cards para la maquetación estática
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Producto 1: Zapatillas Nike (ocupa la mitad del ancho)
            ProductCardVisual(
                productName = "Zapatillas Nike",
                price = "200,00 EUR",
                image = R.drawable.zapatillas_nike,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )

            // Producto 2: Mando Xbox (ocupa la otra mitad)
            ProductCardVisual(
                productName = "Mando Xbox",
                price = "40,00 EUR",
                image = R.drawable.mando_xbox,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            )
        }
    }
}

// Card de Producto Individual
@Composable
fun ProductCardVisual(
    productName: String,
    price: String,
    image: Int,
    modifier: Modifier
) {
    Card(
        modifier = modifier.height(250.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background)


    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // Área de Imagen (Placeholder)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFE5E5E5)), // Fondo gris de la imagen
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Logo de la App",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                // Icono de corazón en la esquina superior derecha (superpuesto)
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = "Add to Favorites",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp),
                    tint = Color.Red
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Información del Producto
            Text(text = productName, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(text = price, fontWeight = FontWeight.Bold, color = Color.Red)
        }
    }
}


@Composable
fun AppBottomBarVisual() {
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
            BottomNavItem(icon = Icons.Default.Home, label = "Home", isSelected = true)
            BottomNavItem(icon = Icons.Default.ChatBubble, label = "Chat")

            // Espacio para el FAB central
            Spacer(modifier = Modifier.width(64.dp))

            BottomNavItem(icon = Icons.Default.Favorite, label = "Favorites")
            BottomNavItem(icon = Icons.Default.Person, label = "Profile")
        }
    }
    // El FAB se superpone encima del BottomAppBar, necesita un Box o similar para posicionarse
    // pero aquí lo pondremos simple para la maquetación.

    // FAB de la Cesta
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-30).dp), // Subir el FAB
        contentAlignment = Alignment.Center
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

@Composable
fun RowScope.BottomNavItem(icon: ImageVector, label: String, isSelected: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.weight(1f)) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) Color.Red else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        // Opcional: Texto pequeño debajo del icono
        // Text(text = label, fontSize = 10.sp, color = if (isSelected) Color.Red else Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreenVisual() {
    HomeScreenVisual()
}