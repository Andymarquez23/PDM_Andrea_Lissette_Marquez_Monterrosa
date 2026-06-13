package com.example.laboratorio4.Navegacion

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.ViewModel.GeneralViewModel

import com.example.laboratorio4.ui.theme.View.Greeting
import com.example.laboratorio4.ui.theme.View.home
import kotlinx.serialization.Serializable


@Serializable
object home
@Serializable
object Vista
@Composable
fun navegacion() {
    val navController = rememberNavController()
    val viewModel: GeneralViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            home(navController, viewModel = viewModel)
        }
        composable(route = "Greeting") {
            Greeting(navController, viewModel = viewModel)
        }
    }
}