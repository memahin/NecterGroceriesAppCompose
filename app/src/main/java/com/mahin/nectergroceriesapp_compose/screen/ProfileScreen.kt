package com.mahin.nectergroceriesapp_compose.screen

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahin.nectergroceriesapp_compose.R

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.propic), // Replace with your profile image resource
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.LightGray, shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = "Rafiul Islam", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "rafiul.mahin1@gmail.com", color = Color.Gray, fontSize = 14.sp)
            }

            //Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.ic_p), // Replace with your edit icon resource
                contentDescription = "null",
                modifier = Modifier.size(15.dp),
                tint = Color.Gray
            )
        }

        // Menu Options
        MenuItem(icon = R.drawable.orders_icon, title = "Orders")
        MenuItem(icon = R.drawable.details_icon, title = "My Details")
        MenuItem(icon = R.drawable.address, title = "Delivery Address")
        MenuItem(icon = R.drawable.vector_icon, title = "Payment Methods")
        MenuItem(icon = R.drawable.cord_icon, title = "Promo Code")
        MenuItem(icon = R.drawable.bell, title = "Notifications")
        MenuItem(icon = R.drawable.help, title = "Help")
        MenuItem(icon = R.drawable.icon, title = "About")

        Spacer(modifier = Modifier.weight(1f))
        //logout
        val context = LocalContext.current

        Button(
            onClick = {
                // Handle log out action here
                (context as? Activity)?.finishAffinity() // Exits the application
            },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(58.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0F7E9))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_log), // Replace with your logout icon resource
                contentDescription = "Logout",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Log Out",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }

    }
}



@Composable
fun MenuItem(icon: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.arrow_right), // Replace with your forward arrow icon resource
            contentDescription = "Next",
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAccount() {
    ProfileScreen()
}