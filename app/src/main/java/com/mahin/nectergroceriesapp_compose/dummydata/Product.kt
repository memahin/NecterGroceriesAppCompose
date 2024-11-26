package com.mahin.nectergroceriesapp_compose.dummydata

import com.mahin.nectergroceriesapp_compose.R

data class Product(
    val name: String,
    val quantity: String,
    val price: String,
    val imageRes: Int
)

val exclusiveProducts = listOf(
    Product("Organic Bananas", "7pcs", "$4.99", R.drawable.grocerybanana),
    Product("Red Apple", "1kg", "$7.99", R.drawable.groceryapple),
    Product("Fruits", "5kg", "$5.99", R.drawable.freshfruit),
    Product("Red Apple", "1kg", "$3.99", R.drawable.groceryapple),
    Product("Red Apple", "1kg", "$4.99", R.drawable.groceryapple)

)