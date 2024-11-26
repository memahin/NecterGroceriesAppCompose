package com.mahin.nectergroceriesapp_compose.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mahin.nectergroceriesapp_compose.R
import com.mahin.nectergroceriesapp_compose.route.BottomNavItem

@Composable
fun CustomBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Shop,
        BottomNavItem.Explore,
        BottomNavItem.Cart,
        BottomNavItem.Favourite,
        BottomNavItem.Account
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
        tonalElevation = 8.dp
    ) {
        NavigationBar(
            containerColor = Color.White
        ) {
            items.forEach { item ->
                val selected = currentRoute == item.route

                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(text = item.title)
                    },
                    selected = selected,
                    onClick = {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = colorResource(id = R.color.nectar_primary_color),
                        selectedTextColor = colorResource(id = R.color.nectar_primary_color),
                        unselectedIconColor = colorResource(id = R.color.black),
                        unselectedTextColor = colorResource(id = R.color.black),
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}
