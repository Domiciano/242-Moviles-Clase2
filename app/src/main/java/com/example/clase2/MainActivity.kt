package com.example.clase2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.clase2.screens.HomeScreen
import com.example.clase2.screens.MenuScreen
import com.example.clase2.ui.theme.Clase2Theme
import com.example.clase2.viewmodel.AppViewModel
import com.example.clase2.viewmodel.ProfileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Clase2Theme {
                App()
            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    val appViewModel:AppViewModel = viewModel()
    NavHost(navController =navController, startDestination = "menu"){
        composable("home"){ HomeScreen(navController, appViewModel) }
        composable("menu?menutype={menutype}", arguments = listOf(
            navArgument("menutype"){type = NavType.StringType}
        )){ entry ->
            val menutype = entry.arguments?.getString("menutype")
            MenuScreen(navController, appViewModel, menutype)
        }
    }
}






@Composable
fun ProfileScreen(profileViewModel: ProfileViewModel = viewModel()){

    val name by profileViewModel.name.observeAsState()
    val email by profileViewModel.email.observeAsState()
    val description by profileViewModel.description.observeAsState()

    //var name by remember { mutableStateOf("NO_NAME") }
    //val email by remember { mutableStateOf("NO_EMAIL") }
    //val description by remember { mutableStateOf("NO_DESC") }


    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = name ?: "NO_NAME")
            Text(text = email ?: "NO_EMAIL")
            Text(text = description ?: "NO_DESC")

            /*
            TextField(value = name, onValueChange = { text ->
                name = text
            })
             */
            Button(onClick = {
                profileViewModel.changeName("Sergio Florez")
            }) {
                Text("Change state")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Clase2Theme {
        HomeScreen()
    }
}