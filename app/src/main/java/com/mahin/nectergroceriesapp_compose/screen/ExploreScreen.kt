package com.mahin.nectergroceriesapp_compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mahin.nectergroceriesapp_compose.R
import com.mahin.nectergroceriesapp_compose.component.DebouncedSearchBar
import com.mahin.nectergroceriesapp_compose.dummydata.Grocery

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    exploreNavController: NavHostController
){

    var searchResult by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Find Products",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp

        )
        Spacer(modifier = Modifier.height(15.dp))

        // Called the DebouncedSearchBar Composable and provide the onSearch callback
        DebouncedSearchBar { query ->

//            searchResult = "You searched for: $query"
        }
        Spacer(modifier = Modifier.height(2.dp))

        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ExploredRandomColoredComp(exploreNavController)
        }
    }
}

@Composable
fun ExploredRandomColoredComp(
    exploreNavController: NavHostController
) {
    // Sample Data
    val groceryExploredItems = listOf(
        Grocery("Fresh Fruits\n& Vegetable", R.drawable.freshfruit),
        Grocery("Cooking Oil\n\t\t& Ghee", R.drawable.cooking_oil),
        Grocery("Meat & Fish", R.drawable.meat_fish),
        Grocery("Bakery & Snacks", R.drawable.snacks),
        Grocery("Dairy & Eggs", R.drawable.diary_eggs),
        Grocery("Beverages", R.drawable.beverages),
        Grocery("Fresh Fruits\n& Vegetable", R.drawable.freshfruit),
        Grocery("Cooking Oil\n\t\t& Ghee", R.drawable.cooking_oil),
        Grocery("Meat & Fish", R.drawable.meat_fish),
        Grocery("Bakery & Snacks", R.drawable.snacks),
        Grocery("Dairy & Eggs", R.drawable.diary_eggs),
        Grocery("Beverages", R.drawable.beverages),
    )

//     Grid layout starts here
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1000.dp) // Set an appropriate height constraint
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(groceryExploredItems)
            { grocery ->
                // Generate a random hue
                val hue = (0..360).random().toFloat()

                // Generate a pastel color for the background using the random hue
                val backgroundColor = Color.hsl(hue, 0.5f, 0.9f)

                // Generate a deeper color for the border using the same hue
                val borderColor = Color.hsl(hue, 0.7f, 0.7f)

                Box(
                    modifier = Modifier
                        .width(174.dp)
                        .height(189.dp)
                        .background(
                            backgroundColor,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = borderColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            exploreNavController.navigate("ExploreDetailsScreen" + "/${grocery.name}")
                        },

                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .padding(15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .height(74.dp)
                                .width(111.dp),
                            painter = painterResource(id = grocery.imageRes),
                            contentDescription = grocery.name,
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            fontSize = 15.sp,
                            text = grocery.name,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExploreScreenPreview(){
    ExploreScreen(exploreNavController = rememberNavController())
}

