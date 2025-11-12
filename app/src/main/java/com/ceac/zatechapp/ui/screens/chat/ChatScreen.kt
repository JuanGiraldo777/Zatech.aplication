package com.ceac.zatechapp.ui.screens.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceac.zatechapp.R
import com.ceac.zatechapp.ui.components.AppBottomBarChange
import com.ceac.zatechapp.ui.theme.BackgroundWhite
import com.ceac.zatechapp.ui.theme.BlackPrimaryText
import com.ceac.zatechapp.ui.theme.PrimaryRed



@Composable
fun ChatScreen() {
    Scaffold(
        bottomBar = {
            AppBottomBarChange(

                selectedItem = "Chat",
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

                TextTopChat()

                Spacer(modifier = Modifier.height(30.dp))

                ConversationPreview(
                    store = "Nike Store",
                    product = "Zapatillas Nike",
                    messagePreview = "Hola si, pero solo en tiendas de....",
                    image = R.drawable.zapatillas_nike,
                    size = 80,
                )

                Spacer(modifier = Modifier.height(30.dp))

                ConversationPreview(
                    store = "GAME",
                    product = "Mando Xbox",
                    messagePreview = "Hola, estan en promoción por c...",
                    image = R.drawable.mando_xbox,
                    size = 80,
                )

                Spacer(modifier = Modifier.height(30.dp))

                ConversationPreview(
                    store = "Decatlon",
                    product = "Zapatillas para caminatas",
                    messagePreview = "Estan disponibles en la tienda.......",
                    image = R.drawable.zapatillas_botas,
                    size = 65,
                )

                Spacer(modifier = Modifier.height(30.dp))

                ConversationPreview(
                    store = "Backmarket ",
                    product = "iPhone 15",
                    messagePreview = "En este momento solo tenem........",
                    image = R.drawable.iphone,
                    size = 45,
                )

                Spacer(modifier = Modifier.height(30.dp))

                ConversationPreview(
                    store = "Media Markt",
                    product = "Redmi Xiaomi 15 ",
                    messagePreview = "Hola si esta disponible en azul......",
                    image = R.drawable.xiaomi,
                    size = 50,
                )


                // Espacio extra al final para asegurar que el último producto no quede pegado al Bottom Bar
                Spacer(modifier = Modifier.height(80.dp))


            }
        }
    )
}

@Composable
fun TextTopChat() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Mensajes",
            style = MaterialTheme.typography.headlineMedium,
            color = BlackPrimaryText,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(15.dp))


    }
}


@Composable
fun ConversationPreview(
    store: String,
    product: String,
    messagePreview: String,
    image: Int,
    size: Int
) {
    Column(modifier = Modifier.padding(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(PrimaryRed, CircleShape)
                    .border(2.dp, BlackPrimaryText, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = product,
                    modifier = Modifier
                        .height(size.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Text(
                    store,
                    fontSize = 14.sp,
                    color = Color(0x60000000),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    product,
                    fontSize = 12.sp,
                    color = BlackPrimaryText,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    messagePreview,
                    fontSize = 12.sp,
                    color = Color(0x40000000),
                    fontWeight = FontWeight.Light
                )
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
        ChatScreen()
    }

}