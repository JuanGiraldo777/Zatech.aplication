package com.ceac.zatechapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.ceac.zatechapp.R


@Composable
fun SimpleDropShadowUsage(
    imagePainter: Painter
) {
    val roundedCornerGlobal = 15.dp

    Box(modifier = Modifier) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .dropShadow(
                    shape = RoundedCornerShape(roundedCornerGlobal),
                    shadow = Shadow(
                        radius = 4.dp,
                        spread = 1.dp,
                        color = Color(0x40000000),
                        offset = DpOffset(x = 0.dp, 4.dp)
                    )
                )
                .align(Alignment.Center)
                .background(
                    color = Color(0xFFEA553B).copy(alpha = 0.65f),
                    shape = RoundedCornerShape(roundedCornerGlobal)
                )
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "Icono de Categoria Home",
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.Fit,
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShadow() {
        SimpleDropShadowUsage(painterResource(id = R.drawable.sneakers))
}