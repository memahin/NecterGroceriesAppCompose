package com.mahin.nectergroceriesapp_compose.screen

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mahin.nectergroceriesapp_compose.R
import com.mahin.nectergroceriesapp_compose.component.CustomButton
import com.mahin.nectergroceriesapp_compose.component.CustomDivider
import com.mahin.nectergroceriesapp_compose.component.CustomEmailView
import com.mahin.nectergroceriesapp_compose.component.CustomPasswordView
import com.mahin.nectergroceriesapp_compose.component.rememberImeState
import com.mahin.nectergroceriesapp_compose.route.Screens

@Composable
fun LogInScreen(navController: NavController) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var userEmailText by remember { mutableStateOf(TextFieldValue("")) }
    var userPasswordText by remember { mutableStateOf(TextFieldValue("")) }
    val isImeVisible by rememberImeState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        // Fixed Background Images
        Image(
            painter = painterResource(id = R.drawable.topbgtwo),
            contentScale = ContentScale.Crop,
            contentDescription = "Top Bar Image",
            modifier = Modifier.fillMaxWidth().height(if (isImeVisible) 0.dp else 250.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.bottombg),
            contentScale = ContentScale.Crop,
            contentDescription = "Bottom Background Image",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )

        // Scrollable Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .align(Alignment.Center),
        ) {
            // Top spacing
            Spacer(modifier = Modifier.height(if (isImeVisible) 100.dp else 250.dp))

            // Main content
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Login",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 15.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Enter your emails and password",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Email",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomEmailView(
                    emailText = userEmailText,
                    onTextChanged = { newText ->
                        userEmailText = newText
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomDivider()

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Password",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                CustomPasswordView(
                    passwordText = userPasswordText,
                    onTextChanged = { newText ->
                        userPasswordText = newText
                    }
                )
                CustomDivider()

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 15.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Forgot Password?",
                            fontSize = 13.sp,
                        )
                    }

                    CustomButton(
                        text = "Login",
                        onClick = {
                            when {
                                userEmailText.text.isEmpty() && userPasswordText.text.isEmpty() -> {
                                    Toast.makeText(
                                        context,
                                        "Please enter a valid email and password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                !Patterns.EMAIL_ADDRESS.matcher(userEmailText.text).matches() -> {
                                    Toast.makeText(context, "Email is invalid.", Toast.LENGTH_SHORT).show()
                                }
                                userPasswordText.text.length < 8 -> {
                                    Toast.makeText(context, "User Password must be at least 8 character", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    navController.navigate(Screens.HomeScreen.route)
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Row {
                        Text(
                            text = "Don't have an account? ",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Signup",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.nectar_primary_color),
                            modifier = Modifier.clickable {
                                focusManager.clearFocus()
                                navController.navigate(Screens.SignUpScreen.route)
                            }
                        )
                    }
                }
            }

            // Bottom spacing
            Spacer(modifier = Modifier.height(200.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LogInScreen(
        navController = rememberNavController()
    )
}