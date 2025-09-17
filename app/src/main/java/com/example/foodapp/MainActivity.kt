package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.foodapp.Screens.HomeScreen
import com.example.foodapp.ui.theme.FoodAppTheme
import com.example.foodapp.ui.theme.AppImages

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HomeScreen(
                        userName = "Grecia",
                        categories = AppImages.categories,
                        restaurants = AppImages.restaurants,
                        foods = emptyList(),
                        onLogout = {}
                    )
                }
            }
        }
    }
}
