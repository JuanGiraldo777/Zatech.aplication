package com.ceac.zatechapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ceac.zatechapp.ui.theme.BackgroundWhite


// ⭐️ Componente Reutilizable para un Botón Social
@Composable
fun SocialButton(
    icon: Any, // ImageVector para el icono
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(56.dp), // Tamaño del círculo
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color(0xFFE0E0E0) // Fondo gris claro del círculo
        )
    ) {
        when (icon) {
            is androidx.compose.ui.graphics.vector.ImageVector -> {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.DarkGray, // Color del icono (gris oscuro)
                    modifier = Modifier.size(32.dp) // Tamaño del icono dentro del círculo
                )
            }
            // Agregar Painter/Drawable para logos oficiales
        }
    }
}

// ⭐️ Componente Contenedor para la Fila de Botones
@Composable
fun SocialButtonsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center // Centra los iconos
    ) {
        // Botón de Facebook
        SocialButton(
            icon = Icons.Filled.Facebook, // Icono de Facebook
            onClick = { /* Lógica de Login con Facebook */ }
        )

        Spacer(modifier = Modifier.width(32.dp)) // Espacio entre los iconos

        // Botón de Google
        SocialButton(
            icon = Icons.Filled.Share, // Icono de Google
            onClick = { /* Lógica de Login con Google */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIconsVisualSocial(){
MaterialTheme(
    colorScheme = lightColorScheme(
    background = BackgroundWhite
)
    ) {
        SocialButtonsRow()
    }
}