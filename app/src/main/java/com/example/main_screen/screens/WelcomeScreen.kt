package com.example.main_screen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.main_screen.R


@Composable
fun WelcomeScreen(navController: NavHostController){

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
           /* Image(
                painter = painterResource(id = R.drawable.imagen_principal),
                contentDescription = "Imagen bienvenida",
                modifier = Modifier
                    .height(350.dp)
            )*/

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
                    Button(
                        onClick = {
                            navController.navigate("loginscreen")
                        }
                    ){
                        Text(
                            text = "Login",
                            fontWeight = FontWeight.Bold
                        )
                    }
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
                    Button(
                        onClick = {
                            navController.navigate("signup")
                        }
                    ){
                        Text(
                            text = "Sign Up",
                            color = Color(0xFF5E4AE3),
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    /*Text(
                        text = "Sign Up",
                        color = Color(0xFF5E4AE3),
                        fontWeight = FontWeight.SemiBold
                    )*/
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



    /*Column(
        modifier = Modifier.fillMaxSize()
    ){
        Button(
            onClick = {
                navController.navigate("signup")
            }
        ){
            Text(text = "Crear cuenta")
        }
    }*/
}