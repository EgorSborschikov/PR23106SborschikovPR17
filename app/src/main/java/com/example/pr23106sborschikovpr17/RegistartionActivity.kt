package com.example.pr23106sborschikovpr17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pr23106sborschikovpr17.ui.theme.PR23106SborschikovPR17Theme

class RegistartionActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PR23106SborschikovPR17Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistrationScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RegistrationScreen(modifier : Modifier = Modifier){
    Box(contentAlignment = Center, modifier = Modifier.fillMaxSize()) {
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
            TextField(

                value = "login",

                onValueChange = { },

                label = { Text("Логин") }

            )

            TextField(

                value = "password",

                onValueChange = { },

                label = { Text("Пароль") }

            )

            Button(onClick = { }) {

                Text("Войти")

            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewRegistationScren(){
    PR23106SborschikovPR17Theme {
        RegistrationScreen()
    }
}