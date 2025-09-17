package com.example.foodapp.ui.theme

import com.example.foodapp.model.Category
import com.example.foodapp.model.Food
import com.example.foodapp.model.Restaurant


object AppImages {


    val categories = listOf(
        Category("Fast Food", "https://img.icons8.com/emoji/240/hamburger-emoji.png"),
        Category("Chinese",   "https://img.icons8.com/color/240/noodles.png"),
        Category("Italian",   "https://img.icons8.com/color/240/pizza.png"),
        Category("Mexican",   "https://img.icons8.com/color/240/taco.png"),
        Category("Desserts",  "https://img.icons8.com/color/240/ice-cream-sundae.png")
    )


    val restaurants = listOf(
        Restaurant("Burger King", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Burger_King_2020.svg/512px-Burger_King_2020.svg.png"),
        Restaurant("McDonald's",  "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"),
        Restaurant("KFC",         "https://w1.pngwing.com/pngs/505/987/png-transparent-kfc-logo-colonel-sanders-fried-chicken-restaurant-fast-food-chicken-as-food-menu-area.png"),
        Restaurant("Domino's",    "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Dominos_pizza_logo.svg/512px-Dominos_pizza_logo.svg.png"),
        Restaurant("Subway",      "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Subway_2016_logo.svg/512px-Subway_2016_logo.svg.png")
    )


    val foods = listOf(
        Food("Whopper", 4.5, 99.8, "https://static9.depositphotos.com/1364311/1231/i/450/depositphotos_12318613-stock-photo-hamburger.jpg"),
        Food("Chicken Fries", 4.3, 59.8, "https://www.wendys.com.mx/sites/default/files/styles/max_650x650/public/2021-12/papas-fritas-full_0.png?itok=RPfgSIKZ"),
        Food("Big Mac", 4.6, 79.8, "https://img.freepik.com/psd-gratis/primer-plano-hamburguesa-aislada_23-2151604203.jpg"),
        Food("McFlurry", 4.7, 49.8, "https://mcdonalds.es/api/cms/images/Z41EV5bqstJ99nSt_McFlurry_Cristal_oreo_chocolate.png?rect=0,0,450,450&auto=compress&fm=webp")
    )




}
