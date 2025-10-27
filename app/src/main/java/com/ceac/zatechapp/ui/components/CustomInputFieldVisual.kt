package com.ceac.zatechapp.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun CustomInputFieldVisual(
    icon: Any, // Puede ser un ImageVector (para Icons.Default) o un Painter (para imágenes drawable)
    placeholder: String,
) {
    //Define el fondo, el color y la forma redondeada
    Surface(
        modifier = Modifier
            .fillMaxWidth()
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
                is androidx.compose.ui.graphics.vector.ImageVector -> {
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
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomInputFieldVisual() {
    CustomInputFieldVisual(
        icon = Icons.Default.Email,
        placeholder = "Correo electrónico",
    )
}