package com.orglegal.fam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.orglegal.fam.features.catalog.presentation.catalog.CatalogScreen
import com.orglegal.fam.features.catalog.presentation.full_list.FullListScreen
import com.orglegal.fam.features.catalog.utils.CategoryNavType
import com.orglegal.fam.ui.theme.FeitoAMãoTheme
import com.orglegal.fam.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeitoAMãoTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.CATALOG
                ){
                    composable(Routes.CATALOG) {
                        CatalogScreen(
                            onNavigate = { navController.navigate(it.route) }
                        )
                    }
                    composable(
                        route = Routes.CATEGORY_FULL_LIST + "?category={category}",
                        arguments = listOf(
                            navArgument(name = "category") {
                                type = CategoryNavType()
                            }
                        )
                    ) {
                        FullListScreen(
                            onPopBackStack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}