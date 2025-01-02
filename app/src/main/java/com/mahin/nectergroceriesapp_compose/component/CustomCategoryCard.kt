package com.mahin.nectergroceriesapp_compose.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahin.nectergroceriesapp_compose.R

@Composable
fun CustomCategoryCard(
    categoryName: String,
    categoryImage: Int, // Add parameter for the image resource
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null // Optional click handler
) {
    Card(
        modifier = modifier
            .height(174.dp)
            .clickable { onClick?.invoke() }, // Make card clickable if onClick is provided
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        backgroundColor = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Image
            Image(
                modifier = Modifier
                    .size(80.dp),
                painter = painterResource(id = categoryImage), // Use dynamic image resource
                contentDescription = "$categoryName Image"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Category Name
            Text(
                text = categoryName,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun CategoryCardPreview() {
    CustomCategoryCard(
        categoryName = "Fresh Fruits & Vegetable", // Sample category name
        categoryImage = R.drawable.freshfruit, // Sample image
        onClick = { /* Handle click */ }
    )
}
