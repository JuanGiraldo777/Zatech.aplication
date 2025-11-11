package com.ceac.zatechapp.ui.screens.shoppingcart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceac.zatechapp.ui.theme.BackgroundWhite
import com.ceac.zatechapp.ui.theme.BlackPrimaryText


@Composable
fun ShoppingCartScreen() {
    Scaffold(

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 20.dp), // Márgenes laterales
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp)) // Espacio superior

                TextTopShoppingCart()


                // Espacio extra al final para asegurar que el último producto no quede pegado al Bottom Bar
                Spacer(modifier = Modifier.height(80.dp))


            }
        }
    )

}
@Composable
fun TextTopShoppingCart(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Cesta",
            style = MaterialTheme.typography.headlineMedium,
            color = BlackPrimaryText,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(30.dp))


    }
}


@Preview(showBackground = true)
@Composable
fun ShoppingCartPreview() {
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = BackgroundWhite
        )
    ) {
        ShoppingCartScreen()
    }
}
