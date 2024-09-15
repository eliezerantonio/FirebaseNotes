package com.example.firebasenotes.views.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firebasenotes.components.Alert
import com.example.firebasenotes.viewModels.LoginViewModel

@Composable

fun RegisterView(navController: NavController, loginViewModel: LoginViewModel) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var username by remember { mutableStateOf("") }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)

        )


        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                loginViewModel.createUser(email, password, username) {
                    navController.navigate("Home")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text("Entrar")
        }

        if (loginViewModel.showAlert) {
            Alert(
                title = "Alert",
                message = "Register Failed",
                confirmText = "Accept",
                dismissText = "OK",
                onConfirmClick = {},
                onDismissClick = {
                    loginViewModel.dismissAlert()
                })
        }


    }


}