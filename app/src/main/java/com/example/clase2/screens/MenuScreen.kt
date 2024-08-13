package com.example.clase2.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clase2.viewmodel.AppViewModel

@Composable
fun MenuScreen(
    navController: NavController = rememberNavController(),
    appViewModel: AppViewModel = viewModel(),
    menutype:String? = ""
) {

    val dishesA = arrayListOf(
        Dish("Punta de anca", 40000),
        Dish("Baby beef", 50000),
        Dish("Arroz con pollo", 25000),
    )
    val dishesB = arrayListOf(
        Dish("Limonada de coco", 10000),
        Dish("Agua de panela", 5000),
        Dish("Coca cola", 3500),
    )
    val dishesC = arrayListOf(
        Dish("Brownie con helado", 18000),
        Dish("Tiramisú", 25000),
        Dish("Malteada", 15000),
    )

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            when(menutype){
                "fuertes" -> {

                }
                "bebidas" -> {

                }
            }

            dishesA.map {
                Column(modifier = Modifier.clickable {
                    Log.e(">>>", it.name)
                }) {
                    Text(text = it.name)
                    Text(text = "${it.price}")
                }
            }
        }
    }
}

data class Dish(var name: String, var price: Int)