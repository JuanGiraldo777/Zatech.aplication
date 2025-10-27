package com.ceac.zatechapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ceac.zatechapp.ui.theme.GraySecondaryText
import com.ceac.zatechapp.ui.theme.SecondaryGreen
import com.ceac.zatechapp.ui.theme.ZATECHAPPTheme

@Composable
fun IndicatorDots(currentIndex: Int, totalDots: Int = 3) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalDots) { index ->
            // Color del punto: Oscuro si es el actual, claro si no
            val color = if (index == currentIndex) SecondaryGreen else GraySecondaryText
            val size = 8.dp

            Box(
                modifier = Modifier
                    .size(size)
                    .padding(horizontal = 4.dp)
                    .background(
                        color = color,
                        shape = CircleShape
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomIndicator() {
    ZATECHAPPTheme {
        IndicatorDots(1, 8)
    }
}