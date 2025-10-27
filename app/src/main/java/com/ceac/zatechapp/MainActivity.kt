package com.ceac.zatechapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ceac.zatechapp.ui.screens.auth.LoginScreenVisual
import com.ceac.zatechapp.ui.theme.ZATECHAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZATECHAPPTheme {

                LoginScreenVisual()


            }

        }
    }
}



