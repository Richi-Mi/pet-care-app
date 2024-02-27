package com.example.coco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coco.model.Routes
import com.example.coco.presentation.PetScreen
import com.example.coco.presentation.components.BottomBar
import com.example.coco.ui.theme.CocoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            CocoAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold (
                    modifier = Modifier
                        .fillMaxSize(),
                    contentColor = MaterialTheme.colorScheme.background,
                    bottomBar = { BottomBar() }
                ) { paddingValues ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MyPetScreen.route
                    ) {
                        composable( Routes.MyPetScreen.route) {
                            PetScreen(paddingValues = paddingValues)
                        }
                    }
                }
            }
        }
    }
}