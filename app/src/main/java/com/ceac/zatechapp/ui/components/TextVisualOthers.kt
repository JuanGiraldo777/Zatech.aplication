package com.ceac.zatechapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ceac.zatechapp.ui.theme.GraySecondaryText

@Composable
fun TextDividerVisualOthers(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        // Línea Divisora Izquierda (ocupa el resto del espacio disponible)
        HorizontalDivider(
            modifier = Modifier.weight(4f),
            thickness = 2.dp,
            color = Color(0xFFEEEBEB)
        )

        Spacer(modifier = Modifier.weight(1f))

        //Texto
        Text(
            text = "otros",
            fontStyle = FontStyle.Italic,
            color = GraySecondaryText,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.weight(1f))

        // Línea Divisora Derecha (ocupa el resto del espacio disponible)
        HorizontalDivider(
            modifier = Modifier.weight(4f),
            thickness = 2.dp,
            color = Color(0xFFEEEBEB)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextDivider(){

    TextDividerVisualOthers()
}