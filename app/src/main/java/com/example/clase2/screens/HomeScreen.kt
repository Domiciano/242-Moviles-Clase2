package com.example.clase2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clase2.viewmodel.AppViewModel

@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    appViewModel: AppViewModel = viewModel()
){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Button(onClick = {
                navController.navigate("menu?menutype=${"fuertes"}")
            }) {
                Text(text = "")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "")
            }
        }
    }

}