package com.example.foodapp.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.model.Category
import com.example.foodapp.model.Food
import com.example.foodapp.model.Restaurant

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
            // ---------- HEADER COMO EN LA IMAGEN ----------
            HeaderGreeting(
                userName = userName,
                onLogout = onLogout
            )

            // Aquí, debajo del header, después agregaremos:
            // - "Nuestras categorias" + LazyRow
            // - "Busca los mejores restaurantes" + LazyRow
            // - "Nuestras mejores comidas" + Grid
        }
    }
}

/** Encabezado con icono de perfil rojo, texto gris oscuro y botón de logout (tal cual la maqueta) */
@Composable
private fun HeaderGreeting(
    userName: String,
    onLogout: () -> Unit
) {
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
            tint = Color(0xFFE53935) // 🔴 rojo
        )

        Spacer(Modifier.width(12.dp))

        Text(
            text = "Hola, $userName",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF3C3C3C) // ⚫ gris oscuro
        )

        Spacer(Modifier.weight(1f))

        IconButton(onClick = onLogout) {
            Icon(
                imageVector = Icons.Outlined.ExitToApp, // 🔴 icono salir a la derecha
                contentDescription = "Cerrar sesión",
                modifier = Modifier.size(28.dp),
                tint = Color(0xFFE53935) // 🔴 rojo
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
        color = Color(0xFF3C3C3C) // mismo gris oscuro de títulos
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            userName = "Grecia",
            categories = emptyList(),
            restaurants = emptyList(),
            foods = emptyList()
        )
    }
}
