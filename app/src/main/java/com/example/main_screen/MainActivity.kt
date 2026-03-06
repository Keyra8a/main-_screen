package com.example.main_screen

import android.R.attr.contentDescription
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main_screen.ui.theme.Main_screenTheme

import java.util.function.IntConsumer


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main_screenTheme {
                Register()
            }
        }
    }
}

@Composable
fun Login() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Login",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF5E4AE3)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // EMAIL
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-Mail") },
                shape = RoundedCornerShape(50.dp),

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "email icon",
                        tint = Color(0xFF5E4AE3)
                    )
                },

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF4F3FF),
                    unfocusedContainerColor = Color(0xFFF4F3FF),

                    focusedIndicatorColor = Color(0xFF5E4AE3),
                    unfocusedIndicatorColor = Color.Transparent,

                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            // PASSWORD
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },

                shape = RoundedCornerShape(50.dp),

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "password icon",
                        tint = Color(0xFF5E4AE3)
                    )
                },

                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) {
                        Icon(
                            imageVector =
                                if (passwordVisible)
                                    Icons.Default.Visibility
                                else
                                    Icons.Default.VisibilityOff,
                            contentDescription = "toggle password"
                        )
                    }
                },

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF4F3FF),
                    unfocusedContainerColor = Color(0xFFF4F3FF),

                    focusedIndicatorColor = Color(0xFF5E4AE3),
                    unfocusedIndicatorColor = Color.Transparent,

                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Forgot your password?",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // BOTÓN LOGIN
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = Color(0xFF5E4AE3),
                        shape = RoundedCornerShape(50.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Don´t have an account? Create or",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier.size(40.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google",
                    modifier = Modifier.size(40.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "LinkedIn",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}
@Composable
fun Register() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatpassword by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Register",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5E4AE3)
                )

            }
            Spacer(modifier = Modifier.height(30.dp))

            // username
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("User name") },

                shape = RoundedCornerShape(50.dp),

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "User name",
                        tint = Color(0xFF5E4AE3)
                    )
                },

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF4F3FF),
                    unfocusedContainerColor = Color(0xFFF4F3FF),

                    focusedIndicatorColor = Color(0xFF5E4AE3),
                    unfocusedIndicatorColor = Color.Transparent,

                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),

                /*modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)*/
            )
            Spacer(modifier = Modifier.height(30.dp))

            // email
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-Mail") },

                shape = RoundedCornerShape(50.dp),

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "email icon",
                        tint = Color(0xFF5E4AE3)
                    )
                },

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF4F3FF),
                    unfocusedContainerColor = Color(0xFFF4F3FF),

                    focusedIndicatorColor = Color(0xFF5E4AE3),
                    unfocusedIndicatorColor = Color.Transparent,

                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),

                /*modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)*/
            )
            Spacer(modifier = Modifier.height(30.dp))
            // PASSWORD
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },

                shape = RoundedCornerShape(50.dp),

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "password icon",
                        tint = Color(0xFF5E4AE3)
                    )
                },



                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF4F3FF),
                    unfocusedContainerColor = Color(0xFFF4F3FF),

                    focusedIndicatorColor = Color(0xFF5E4AE3),
                    unfocusedIndicatorColor = Color.Transparent,

                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),

                /*modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)*/
            )

            Spacer(modifier = Modifier.height(15.dp))
            // PASSWORD
            TextField(
                value = repeatpassword,
                onValueChange = { repeatpassword = it },
                label = { Text("Repeat password") },

                shape = RoundedCornerShape(50.dp),

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "password icon",
                        tint = Color(0xFF5E4AE3)
                    )
                },



                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF4F3FF),
                    unfocusedContainerColor = Color(0xFFF4F3FF),

                    focusedIndicatorColor = Color(0xFF5E4AE3),
                    unfocusedIndicatorColor = Color.Transparent,

                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),

                /*modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)*/
            )

            Spacer(modifier = Modifier.height(15.dp))
            // BOTÓN register
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = Color(0xFF5E4AE3),
                        shape = RoundedCornerShape(50.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Register",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            // BOTÓN regresar
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}

@Composable
fun LoginScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // IMAGEN SUPERIOR
            Image(
                painter = painterResource(id = R.drawable.imagen_principal),
                contentDescription = "Imagen bienvenida",
                modifier = Modifier
                    .height(350.dp)
            )

            // TEXTO
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Hello",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Welcome To Little Drop, where\nyou manage you daily tasks",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }

            // BOTONES Y REDES
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                // LOGIN
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            color = Color(0xFF5E4AE3),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // SIGN UP
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFF5E4AE3),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color(0xFF5E4AE3),
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Sign up using",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Facebook",
                        modifier = Modifier.size(40.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google",
                        modifier = Modifier.size(40.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = "LinkedIn",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    Main_screenTheme {
        LoginScreen()
        Login()
        Register()
    }
}
