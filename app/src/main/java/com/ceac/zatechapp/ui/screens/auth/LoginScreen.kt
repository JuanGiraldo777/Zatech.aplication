package com.ceac.zatechapp.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ceac.zatechapp.R
import com.ceac.zatechapp.ui.theme.BackgroundWhite
import com.ceac.zatechapp.ui.theme.BlackPrimaryText
import com.ceac.zatechapp.ui.theme.PrimaryRed
import com.ceac.zatechapp.ui.theme.PurpleLinks
import androidx.compose.ui.draw.shadow
import com.ceac.zatechapp.ui.components.CustomInputFieldVisual
import com.ceac.zatechapp.ui.components.SocialButtonsRow
import com.ceac.zatechapp.ui.components.TextDividerVisualOthers
import com.ceac.zatechapp.ui.theme.GraySecondaryText

@Composable
fun LoginScreenVisual() {
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
                LoginHeaderVisual()

                Spacer(modifier = Modifier.height(15.dp))

                // Campos de Formulario (Email y Contraseña)
                LoginFieldsVisual()

                Spacer(modifier = Modifier.height(35.dp))

                // Botón Principal de Login
                LoginButtonVisual()

                Spacer(modifier = Modifier.height(32.dp))

                //Iconos de otro registro
                LoginIconsVisual()

                Spacer(modifier = Modifier.height(5.dp))

                // Enlace para Registrarse
                RegisterLinkVisual()

                Spacer(modifier = Modifier.height(0.dp))

                // Enlace 'Forgot Password'
                ForgotPasswordLinkVisual()

                Spacer(modifier = Modifier.height(0.dp))

                // Enlace 'Reset Password'
                ResetPasswordLinkVisual()
            }
        }
    )
}


@Composable
fun LoginHeaderVisual() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Logo Login
        Image(
            painter = painterResource(id = R.drawable.logo_login),
            contentDescription = "Logo de la App",
            modifier = Modifier.size(230.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título "Login"
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))


    }
}




@Composable
fun LoginFieldsVisual() {
    Column(modifier = Modifier.fillMaxWidth()) {

        // Campo de Email
        CustomInputFieldVisual(
            icon = Icons.Default.Email,
            placeholder = "Email",
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Campo de Password
        CustomInputFieldVisual(
            icon = Icons.Default.Lock,
            placeholder = "Password",
        )
    }
}


@Composable
fun LoginButtonVisual() {
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
            text = "Login",
            color = BlackPrimaryText,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 18.sp
        )
    }
}

@Composable
fun LoginIconsVisual(){
    Column(modifier = Modifier.fillMaxWidth()) {

        TextDividerVisualOthers()

        Spacer(modifier = Modifier.height(16.dp))

        SocialButtonsRow()

    }
}

@Composable
fun RegisterLinkVisual() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "¿No tienes cuenta? ",
            fontStyle = FontStyle.Italic,
            color = GraySecondaryText,
            style = MaterialTheme.typography.bodyMedium
        )
        TextButton(onClick = { /* Solo maquetación */ }) {
            Text(
                text = "Regístrate",
                color = PurpleLinks,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ForgotPasswordLinkVisual() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "¿Se te olvido la contraseña? ",
            fontStyle = FontStyle.Italic,
            color = GraySecondaryText,
            style = MaterialTheme.typography.bodyMedium
        )
        TextButton(onClick = { /* Solo maquetación */ }) {
            Text(
                text = "Recuperala",
                color = PurpleLinks,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ResetPasswordLinkVisual() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "¿No la recuerdas aún? ",
            fontStyle = FontStyle.Italic,
            color = GraySecondaryText,
            style = MaterialTheme.typography.bodyMedium
        )
        TextButton(onClick = { /* Solo maquetación */ }) {
            Text(
                text = "Restablecela",
                color = PurpleLinks,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreenVisual() {
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = BackgroundWhite
        )
    ) {
        LoginScreenVisual()
    }
}
