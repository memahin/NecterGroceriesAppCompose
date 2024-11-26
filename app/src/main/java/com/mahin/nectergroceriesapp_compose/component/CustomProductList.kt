package com.mahin.nectergroceriesapp_compose.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CustomProductList(shopNavController: NavHostController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp)
    ) {
        items(exclusiveProducts) { product ->
            CustomProductCard(
                productName = product.name,
                productQuantity = product.quantity,
                productPrice = product.price,
                productImage = painterResource(id = product.imageRes),
                shopNavController,
                onAddClick = {

                }
            )
        }
    }
}