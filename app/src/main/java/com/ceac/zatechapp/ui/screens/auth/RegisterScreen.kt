package com.ceac.zatechapp.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.ceac.zatechapp.ui.components.SocialButtonsRow
import com.ceac.zatechapp.ui.components.TextDividerVisualOthers
import com.ceac.zatechapp.ui.theme.BackgroundWhite
import com.ceac.zatechapp.ui.theme.BlackPrimaryText
import com.ceac.zatechapp.ui.theme.GraySecondaryText
import com.ceac.zatechapp.ui.theme.PrimaryRed
import com.ceac.zatechapp.ui.theme.PurpleLinks

@Composable
fun RegisterScreenVisual() {
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

                // Cabecera (Logo y Título)
                RegisterHeaderVisual()

                Spacer(modifier = Modifier.height(15.dp))

                // Campos de Formulario (Email y Password y Username)
                RegisterFieldsVisual()

                Spacer(modifier = Modifier.height(35.dp))

                // Botón Principal de Register
                RegisterButtonVisual()

                Spacer(modifier = Modifier.height(32.dp))

                //Iconos de otro registro
                RegisterIconsVisual()

                Spacer(modifier = Modifier.height(5.dp))

                // Enlace Login
                LoginLinkVisual()

            }
        }
    )
}


@Composable
fun RegisterHeaderVisual() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
    //Logo Register
        Image(
            painter = painterResource(id = R.drawable.logo_register),
            contentDescription = "Logo de app Register",
            modifier = Modifier.size(230.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text (
            text = "Register",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

    }
}


@Composable
fun RegisterFieldsVisual() {
    Column(modifier = Modifier.fillMaxWidth()) {

        //Campo de Email
        CustomInputFieldVisual(
            icon = Icons.Default.Email,
            placeholder = "Email",
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Campo de Username
        CustomInputFieldVisual(
            icon = Icons.Default.Person,
            placeholder = "Username",
        )
        Spacer(modifier = Modifier.height(16.dp))

        //  Campo de Password
        CustomInputFieldVisual(
            icon = Icons.Default.Lock,
            placeholder = "Password",
        )
    }
}


@Composable
fun RegisterButtonVisual() {
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
            containerColor = PrimaryRed // Color de fondo (Rojo)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = "Register",
            color = BlackPrimaryText,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 18.sp
        )
    }
}


@Composable
fun RegisterIconsVisual(){
    Column(modifier = Modifier.fillMaxWidth()) {

        TextDividerVisualOthers()

        Spacer(modifier = Modifier.height(16.dp))

        SocialButtonsRow()

    }
}

@Composable
fun LoginLinkVisual() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "¿Tienes cuenta? ",
            fontStyle = FontStyle.Italic,
            color = GraySecondaryText,
            style = MaterialTheme.typography.bodyMedium
        )
        TextButton(onClick = { /* Solo maquetación */ }) {
            Text(
                text = "Login",
                color = PurpleLinks,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
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
        RegisterScreenVisual()
    }
}