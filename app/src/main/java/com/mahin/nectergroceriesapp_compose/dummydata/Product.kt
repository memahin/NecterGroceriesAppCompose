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

val items = listOf(
    Product("Sprite Can", "325ml, Price", "$1.50", R.drawable.sprite),
    Product("Diet Coke", "355ml, Price", "$1.99", R.drawable.diet_coke),
    Product("Apple & Grape Juice", "2L, Price", "$15.50", R.drawable.apple_juice),
    Product("Coca Cola Can", "325ml, Price", "$4.99", R.drawable.coke),
    Product("Pepsi Can", "330ml, Price", "$4.99", R.drawable.pepsi),
    Product("Diet Coke", "355ml, Price", "$1.99", R.drawable.orange_juice),
    Product("Apple & Grape Juice", "2L, Price", "$15.50", R.drawable.apple_juice),
    Product("Coca Cola Can", "325ml, Price", "$4.99", R.drawable.diet_coke),
    Product("Pepsi Can", "330ml, Price", "$4.99", R.drawable.pepsi)
)