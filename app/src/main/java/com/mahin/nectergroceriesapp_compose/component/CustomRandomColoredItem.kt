package com.mahin.nectergroceriesapp_compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mahin.nectergroceriesapp_compose.dummydata.groceryItems

@Composable
fun CustomRandomColoredItem(shopNavController: NavHostController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(groceryItems) { grocery ->
            val backgroundColor = remember { generateRandomPastelColor() }
            Box(
                modifier = Modifier
                    .width(248.dp)
                    .height(105.dp)
                    .background(
                        backgroundColor,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .clickable {
                        shopNavController.navigate("GroceriesDetailScreen")
                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier
                            .height(71.dp)
                            .width(71.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = painterResource(id = grocery.imageRes),
                            contentDescription = grocery.name,
                            contentScale = ContentScale.Fit
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        fontSize = 19.sp,
                        text = grocery.name,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

// Utility function to generate a random pastel color
fun generateRandomPastelColor(): Color {
    val hue = (0..360).random().toFloat()        // Full range of hues for diversity
    val saturation = 0.5f                        // Fixed low saturation for pastel
    val lightness = 0.9f                         // High lightness for pastel tones
    // Convert HSL to RGB manually as HSL support might vary
    val c = (1 - kotlin.math.abs(2 * lightness - 1)) * saturation
    val x = c * (1 - kotlin.math.abs((hue / 60) % 2 - 1))
    val m = lightness - c / 2
    val (r, g, b) = when {
        hue < 60 -> Triple(c, x, 0f)
        hue < 120 -> Triple(x, c, 0f)
        hue < 180 -> Triple(0f, c, x)
        hue < 240 -> Triple(0f, x, c)
        hue < 300 -> Triple(x, 0f, c)
        else -> Triple(c, 0f, x)
    }
    return Color((r + m), (g + m), (b + m), 1f)
}
