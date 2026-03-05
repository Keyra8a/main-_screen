package com.example.main_screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main_screen.ui.theme.Main_screenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main_screenTheme {
                Login()
            }
        }
    }
}

@Composable
fun Login() {
    var email by remember { mutableStateOf("") }
    var password by remember {mutableStateOf(value = "")}

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Login!",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Sign In to your account",
                    fontWeight = FontWeight.Bold
                )
            }
            TextField(
                value = email,
                onValueChange = { nuevaLetra ->
                    email = nuevaLetra
                },
                label = { Text("E-Mail") },
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
            )
            TextField(
                value = password,
                onValueChange = { nuevaLetra ->
                    password = nuevaLetra
                },
                label = {Text (text = "Password")},
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp)

            )
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
    }
}
