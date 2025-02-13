package com.mahin.nectergroceriesapp_compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mahin.nectergroceriesapp_compose.R

@Composable
fun FloatingNextButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .clickable { onClick() }
            .background(Color.Transparent)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_btn),
            contentDescription = "Arrow Image",
            modifier = Modifier
                .size(56.dp)
        )
    }
}