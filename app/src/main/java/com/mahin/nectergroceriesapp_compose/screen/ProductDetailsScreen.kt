package com.mahin.nectergroceriesapp_compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahin.nectergroceriesapp_compose.R

@Composable
fun ProductDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Handle back action */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            IconButton(onClick = { /* Handle favorite action */ }) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
            }
        }

        // Product Image
        Image(
            painter = painterResource(id = R.drawable.ic_fst), // replace with actual image resource
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Product Title and Price
        Text(text = "Naturel Red Apple", style = MaterialTheme.typography.headlineLarge)
        Text(text = "1kg, Price", style = MaterialTheme.typography.bodyLarge, color = Color.Gray)
        Text(
            text = "$4.99",
            style = MaterialTheme.typography.headlineMedium, // Updated from h5 to headlineMedium
            color = Color.Black,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Quantity Selector
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Decrease quantity */ }) {
                Icon(Icons.Default.ArrowDropDown, contentDescription = "Decrease Quantity")
            }
            Text(text = "1", style = MaterialTheme.typography.headlineLarge)
            IconButton(onClick = { /* Increase quantity */ }) {
                Icon(Icons.Default.Add, contentDescription = "Increase Quantity")
            }
        }

        // Product Detail Section
        ExpandableSection(title = "Product Detail") {
            Text(
                text = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart. As part of a healthful and varied diet.",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        // Nutrition Section
        ExpandableSection(title = "Nutritions") {
            Text(text = "100g", style = MaterialTheme.typography.bodyLarge)
        }

        // Review Section
        ExpandableSection(title = "Review") {
            Row(verticalAlignment = Alignment.CenterVertically) {
                repeat(5) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = Color(0xFFFFD700) // Gold color for stars
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Add to Basket Button
        FloatingActionButton(onClick = { /* Add to basket action */ }, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            containerColor = colorResource(id = R.color.nectar_primary_color)) {
            Text(text = "Add To Cart", color = Color.White)
        }
    }
}

@Composable
fun ExpandableSection(title: String, content: @Composable () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Icon(
                imageVector = if (expanded) {
                    Icons.Default.KeyboardArrowLeft
                } else Icons.Default.KeyboardArrowRight,
                contentDescription = "Expand Icon"
            )
        }
        if (expanded) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    ProductDetailScreen()
}