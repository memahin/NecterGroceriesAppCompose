package com.mahin.nectergroceriesapp_compose.route

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahin.nectergroceriesapp_compose.component.CustomBottomNavigation
import com.mahin.nectergroceriesapp_compose.screen.CartScreen
import com.mahin.nectergroceriesapp_compose.screen.ExploreScreen
import com.mahin.nectergroceriesapp_compose.screen.FavouriteScreen
import com.mahin.nectergroceriesapp_compose.screen.LogInScreen
import com.mahin.nectergroceriesapp_compose.screen.MapScreen
import com.mahin.nectergroceriesapp_compose.screen.OnboardingScreen
import com.mahin.nectergroceriesapp_compose.screen.PhoneNumberInputScreen
import com.mahin.nectergroceriesapp_compose.screen.ProfileScreen
import com.mahin.nectergroceriesapp_compose.screen.ShopScreen
import com.mahin.nectergroceriesapp_compose.screen.SignInScreen
import com.mahin.nectergroceriesapp_compose.screen.SignUpScreen
import com.mahin.nectergroceriesapp_compose.screen.SplashScreen
import com.mahin.nectergroceriesapp_compose.screen.VerificationScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.OnboardingScreen.route) {
            OnboardingScreen(navController)
        }
        composable(route = Screens.SignInScreen.route) {
            SignInScreen(navController)
        }
        composable(route = Screens.PhoneNumberInputScreen.route) {
            PhoneNumberInputScreen(navController)
        }
        composable(route = Screens.VerificationScreen.route) {
            VerificationScreen(navController)
        }
        composable(route = Screens.MapScreen.route) {
            MapScreen(navController)
        }
        composable(route = Screens.LogInScreen.route) {
            LogInScreen(navController)
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen(navController)
        }
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController)
        }
    }
}

@Composable
fun HomeScreen(rootNavController: NavController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            CustomBottomNavigation(navController = bottomNavController)
        }
    ) { paddingValues ->
        NavHost(
            navController = bottomNavController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomNavItem.Home.route) { ShopScreen(rootNavController, bottomNavController) }
            composable(BottomNavItem.Explore.route) { ExploreScreen(Modifier.fillMaxWidth(), bottomNavController) }
            composable(BottomNavItem.Cart.route) { CartScreen(Modifier.fillMaxWidth(), bottomNavController) }
            composable(BottomNavItem.Favourite.route) { FavouriteScreen() }
            composable(BottomNavItem.Account.route) { ProfileScreen() }
        }
    }
}
