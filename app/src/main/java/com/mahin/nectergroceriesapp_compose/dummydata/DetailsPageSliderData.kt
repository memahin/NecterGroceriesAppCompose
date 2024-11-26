package com.mahin.nectergroceriesapp_compose.dummydata

import com.mahin.nectergroceriesapp_compose.R

data class DetailsPageSliderData(
    val title : String,
    val desc : String,
    val imgUrl: Int
)


val detailsPageSliderDataList = listOf(
    DetailsPageSliderData(
        "Discount groceries",
        "These all Groceries are discounted 50%",
        R.drawable.redapplebig
    ),
    DetailsPageSliderData(
        "All fruits",
        "These all Groceries are discounted 30%",
        R.drawable.groceryapple
    ),
    DetailsPageSliderData(
        "All groceries",
        "These all Groceries are discounted 20%",
        R.drawable.freshfruit
    ),
)