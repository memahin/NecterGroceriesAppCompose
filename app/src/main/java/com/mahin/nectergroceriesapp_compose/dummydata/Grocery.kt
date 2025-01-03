package com.mahin.nectergroceriesapp_compose.dummydata

import com.mahin.nectergroceriesapp_compose.R

data class Grocery(
    val name: String,
    val imageRes: Int
)

val groceryItems = listOf(
    Grocery("Pulses", R.drawable.grocery_pulses),
    Grocery("Rice", R.drawable.grocery_rice),
    Grocery("Fruits", R.drawable.freshfruit),
    Grocery("Pulses", R.drawable.grocery_pulses),
    Grocery("Rice", R.drawable.grocery_rice)
)