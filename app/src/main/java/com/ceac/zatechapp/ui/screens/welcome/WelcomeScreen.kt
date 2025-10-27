package com.ceac.zatechapp.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceac.zatechapp.R
import com.ceac.zatechapp.ui.components.IndicatorDots
import com.ceac.zatechapp.ui.theme.BackgroundWhite
import com.ceac.zatechapp.ui.theme.BlackPrimaryText
import com.ceac.zatechapp.ui.theme.SecondaryGreen

@Composable
fun WelcomeScreenVisual() {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp), // Márgenes laterales
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(50.dp)) // Espacio superior

                // Cabecera (Logo, Título y descripcion)
                WelcomeHeaderVisual()

                Spacer(modifier = Modifier.height(35.dp))

                IndicatorDotsVisual()

                Spacer(modifier = Modifier.height(35.dp))

                // Botón Principal de Welcome
                WelcomeButtonVisual()


            }
        }
    )
}


@Composable
fun WelcomeHeaderVisual() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        //Logo Register
        Image(
            painter = painterResource(id = R.drawable.logo_register),
            contentDescription = "Logo de app Register",
            modifier = Modifier.size(230.dp),
            contentScale = ContentScale.Fit
        )

    }

    Spacer(modifier = Modifier.height(16.dp))

    Column(horizontalAlignment = Alignment.CenterHorizontally){
        // Título de bienvenida
        Text(
            text = "Bienvenido a tu\nE-Commerce de\nconfianza!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 36.sp // Ayuda a que las líneas no se peguen
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Caja de texto descriptiva

            Text(
                text = "Podrás encontrar cualquier producto relacionado con zapatillas y tecnología",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(12.dp),
                fontStyle = FontStyle.Italic,
                color = Color.Gray
            )

    }
}

@Composable
fun IndicatorDotsVisual(){
    Column(modifier = Modifier.fillMaxWidth()){
        IndicatorDots(1,3)
    }
}

@Composable
fun WelcomeButtonVisual() {
    Button(
        onClick = { /* Solo maquetación */ },
        modifier = Modifier
            //Sombra del boton
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp),
                ambientColor = Color.Black.copy(alpha = 0.2f),
                spotColor = Color.Black.copy(alpha = 0.5f)
            )
            .width(200.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = SecondaryGreen
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = "Next",
            color = BlackPrimaryText,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 18.sp
        )
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreenVisual() {
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = BackgroundWhite
        )
    ) {
        WelcomeScreenVisual()
    }
}