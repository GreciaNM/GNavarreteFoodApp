package com.example.foodapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.model.Category
import com.example.foodapp.model.Food
import com.example.foodapp.model.Restaurant
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.example.foodapp.ui.theme.AppImages
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

@Composable
fun HomeScreen(
    userName: String,
    categories: List<Category>,
    restaurants: List<Restaurant>,
    foods: List<Food>,
    onLogout: () -> Unit = {}
) {
    Scaffold { inner ->
        Column(
            Modifier
                .padding(inner)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {


            HeaderGreeting(userName = userName, onLogout = onLogout)


            SectionTitle("Nuestras categorias")
            CategoriesRow(categories)
            Spacer(Modifier.height(8.dp))


            SectionTitle("Busca los mejores\nrestaurantes")
            RestaurantsRow(restaurants)
            Spacer(Modifier.height(8.dp))


            SectionTitle("Nuestras mejores comidas")
            FoodsGrid(foods)
            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun HeaderGreeting(userName: String, onLogout: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.AccountCircle,
            contentDescription = "Perfil",
            modifier = Modifier.size(32.dp),
            tint = Color(0xFFE53935)
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text = "Hola, $userName",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF3C3C3C)
        )
        Spacer(Modifier.weight(1f))
        IconButton(onClick = onLogout) {
            Icon(
                imageVector = Icons.Outlined.ExitToApp,
                contentDescription = "Cerrar sesión",
                modifier = Modifier.size(28.dp),
                tint = Color(0xFFE53935)
            )
        }
    }
    Spacer(Modifier.height(12.dp))
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp),
        color = Color(0xFF3C3C3C)
    )
}

/* ------------------ CATEGORÍAS ------------------ */
@Composable
private fun CategoriesRow(categories: List<Category>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
        items(categories) { cat -> CategoryItem(cat) }
    }
}

@Composable
private fun CategoryItem(category: Category) {
    Column(
        modifier = Modifier.width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
                .background(Color(0xFFE53935)),
            contentAlignment = Alignment.Center
        ) {
            GlideImage(
                imageModel = { category.imageUrl },
                imageOptions = ImageOptions(contentScale = ContentScale.Fit),
                modifier = Modifier.size(64.dp)
            )
        }
        Spacer(Modifier.height(6.dp))
        Text(
            text = category.name,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color(0xFF3C3C3C)
        )
    }
}

/* ------------------ RESTAURANTES ------------------ */
@Composable
private fun RestaurantsRow(restaurants: List<Restaurant>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
        items(restaurants) { r -> RestaurantItem(r) }
    }
}

@Composable
private fun RestaurantItem(restaurant: Restaurant) {
    Column(
        modifier = Modifier.width(120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            GlideImage(
                imageModel = { restaurant.imageUrl },
                imageOptions = ImageOptions(contentScale = ContentScale.Fit),
                modifier = Modifier
                    .size(72.dp)
                    .padding(8.dp)
            )
        }

        Spacer(Modifier.height(6.dp))

        Text(
            text = restaurant.name,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color(0xFF3C3C3C)
        )
    }
}

/* ------------------ COMIDAS ------------------ */
@Composable
private fun FoodsGrid(foods: List<Food>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier.height(520.dp) // ajusta si necesitas más/menos alto
    ) {
        items(foods) { f ->
            FoodItem(food = f)
        }
    }
}

@Composable
private fun FoodItem(food: Food) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.size(160.dp),
            contentAlignment = Alignment.BottomEnd
        ) {

            GlideImage(
                imageModel = { food.imageUrl },
                imageOptions = ImageOptions(contentScale = ContentScale.Fit),
                modifier = Modifier.size(140.dp)
            )


            Box(
                modifier = Modifier
                    .padding(end = 6.dp, bottom = 6.dp)
                    .background(
                        color = Color(0xFFE53935),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 14.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$${food.price}",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(Modifier.height(6.dp))


        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Rating",
                tint = Color(0xFF27AE60), // verde
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(6.dp))
            Text(
                text = "${food.rating} ${food.name}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF3C3C3C)
            )
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            userName = "Grecia",
            categories = AppImages.categories,
            restaurants = AppImages.restaurants,
            foods = AppImages.foods
        )
    }
}
