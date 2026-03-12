package com.example.main_screen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.main_screen.R

@Composable
fun SignUpScreen(navController: NavHostController) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatpassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var repeatPasswordVisible by remember { mutableStateOf(false) }

    // Variables para validación
    val isNameValid = username.all { it.isLetter() || it.isWhitespace() } && username.isNotBlank()
    val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPhoneValid = phone.all { it.isDigit() } && phone.length == 10
    val isPasswordValid = password == repeatpassword && password.isNotBlank()

    val isFormValid = isNameValid && isEmailValid && isPhoneValid && isPasswordValid

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
                onValueChange = { newValue ->
                    if(newValue.all { it.isLetter() || it.isWhitespace() }){
                        username = newValue
                    }
                },
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
                )
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
                )
            )
            Spacer(modifier = Modifier.height(30.dp))

            // phone
            TextField(
                value = phone,
                onValueChange = {
                    if (it.length <= 10 && it.all { char -> char.isDigit() }) {
                        phone = it
                    }
                },
                label = { Text("Phone") },
                shape = RoundedCornerShape(50.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "phone icon",
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
                )
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
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña",
                            tint = Color(0xFF5E4AE3)
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF4F3FF),
                    unfocusedContainerColor = Color(0xFFF4F3FF),
                    focusedIndicatorColor = Color(0xFF5E4AE3),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            // REPEAT PASSWORD
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
                trailingIcon = {
                    IconButton(onClick = { repeatPasswordVisible = !repeatPasswordVisible }) {
                        Icon(
                            imageVector = if (repeatPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (repeatPasswordVisible) "Ocultar contraseña" else "Mostrar contraseña",
                            tint = Color(0xFF5E4AE3)
                        )
                    }
                },
                visualTransformation = if (repeatPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF4F3FF),
                    unfocusedContainerColor = Color(0xFFF4F3FF),
                    focusedIndicatorColor = Color(0xFF5E4AE3),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            // BOTÓN register
            Button(
                onClick = {
                    navController.navigate("welcome")
                },
                enabled = isFormValid,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5E4AE3),
                    disabledContainerColor = Color(0xFF5E4AE3).copy(alpha = 0.5f)
                )
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
                Button(
                    onClick = {
                        navController.navigate("welcome")
                    }
                )  {
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

    /*Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navController.navigate("welcome")
            }
        )  {
            Text(text = "Volver")
        }
    }*/
}