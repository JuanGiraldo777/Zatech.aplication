package com.ceac.zatechapp.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceac.zatechapp.R
import com.ceac.zatechapp.ui.components.CustomInputFieldVisual
import com.ceac.zatechapp.ui.theme.BackgroundWhite
import com.ceac.zatechapp.ui.theme.BlackPrimaryText
import com.ceac.zatechapp.ui.theme.SecondaryGreen

@Composable
fun RecoverScreenVisual() {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp), // Márgenes laterales
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp)) // Espacio superior

                // Cabecera (Logo y Título)
                RecoverHeaderVisual()

                Spacer(modifier = Modifier.height(15.dp))

                // Campos de Formulario (Email y Contraseña)
                RecoverFieldsVisual()

                Spacer(modifier = Modifier.height(80.dp))

                // Botón Principal de Recover
                RecoverButtonVisual()


            }
        }
    )
}


@Composable
fun RecoverHeaderVisual() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        // Logo Recover
        Image(
            painter = painterResource(id = R.drawable.logo_login),
            contentDescription = "Logo de la App",
            modifier = Modifier.size(230.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título "Recover Password"
        Text(
            text = "Recover Password",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))


    }
}


@Composable
fun RecoverFieldsVisual() {
    Column(modifier = Modifier.fillMaxWidth()) {

        // Campo de Email
        CustomInputFieldVisual(
            icon = Icons.Default.Email,
            placeholder = "Email",
        )

        Spacer(modifier = Modifier.height(35.dp))

        //Campo de Password
        CustomInputFieldVisual(
            icon = Icons.Default.Person,
            placeholder = "Username",
        )
    }
}


@Composable
fun RecoverButtonVisual() {
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
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = SecondaryGreen // Color de fondo (Rojo)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = "Recover",
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
fun RecoverPreviewScreenVisual() {
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = BackgroundWhite
        )
    ) {
        RecoverScreenVisual()
    }
}
