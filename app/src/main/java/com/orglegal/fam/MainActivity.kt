package com.orglegal.fam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.orglegal.fam.features.catalog.presentation.CatalogScreen
import com.orglegal.fam.ui.theme.FeitoAMãoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeitoAMãoTheme {
                CatalogScreen()
            }
        }
    }
}