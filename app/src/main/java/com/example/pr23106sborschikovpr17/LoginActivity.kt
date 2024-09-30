package com.example.pr23106sborschikovpr17

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pr23106sborschikovpr17.ui.theme.PR23106SborschikovPR17Theme
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PR23106SborschikovPR17Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LaunchScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier : Modifier = Modifier){
    val auth = FirebaseAuth.getInstance()

    val context = LocalContext.current
    
    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(contentAlignment = Center, modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(R.drawable.bgr_login_scr),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = login.value,
                onValueChange = { login.value = it },
                label = { Text("Логин") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Пароль") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    auth.signInWithEmailAndPassword(login.value, password.value).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(context, MainActivity::class.java)
                            context.startActivity(intent)
                        } else {
                            Toast.makeText(
                                context,
                                "Такого аккаунта не существует",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(context, RegistartionActivity::class.java)
                            context.startActivity(intent)
                        }
                    }
                },
            ){
                Text("Войти")
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Забыли пароль?",
                modifier = Modifier.clickable(onClick = { /* обработка восстановления пароля */ })
            )
        }
    }
}

@Preview
@Composable
fun DefaulPreviewLoginScreen(){
    PR23106SborschikovPR17Theme {
        LoginScreen()
    }
}