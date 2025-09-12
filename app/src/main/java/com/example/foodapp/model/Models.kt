package com.example.foodapp.model

data class Category(val name: String, val imageUrl: String)
data class Restaurant(val name: String, val imageUrl: String)
data class Food(val name: String, val rating: Double, val price: Double, val imageUrl: String)
