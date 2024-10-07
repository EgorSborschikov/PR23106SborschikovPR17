package com.example.pr23106sborschikovpr17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pr23106sborschikovpr17.ui.theme.PR23106SborschikovPR17Theme
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PR23106SborschikovPR17Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Box(

        modifier = Modifier

            .fillMaxSize()

            .padding(16.dp)

    ) {

        GoogleMap(

            modifier = Modifier

                .fillMaxSize(),

            cameraPositionState = rememberCameraPositionState {

                position = CameraPosition.fromLatLngZoom(

                    LatLBox(

                        modifier = Modifier

                            .fillMaxSize()

                            .padding(16.dp)

                    ) {

                        GoogleMap(

                            modifier = Modifier

                                .fillMaxSize(),

                            cameraPositionState = rememberCameraPositionState {

                                position = CameraPosition.fromLatLngZoom(

                                    LatLng(55.751579, 37.617664),

                                    16f

                                )

                            },

                            onMapClick = { },

                            contentDescription = "Mapa"

                        )



                        Button(

                            onClick = { },

                            modifier = Modifier

                                .align(Alignment.TopEnd)

                                .padding(16.dp)

                        ) {

                            Icon(

                                imageVector = Icons.Filled.Menu,

                                contentDescription = "Menu"

                            )

                        }

                    }ng(55.751579, 37.617664),

                    16f

                )

            },

            onMapClick = { },

            contentDescription = "Mapa"

        )



        Button(

            onClick = { },

            modifier = Modifier

                .align(Alignment.TopEnd)

                .padding(16.dp)

        ) {

            Icon(

                imageVector = Icons.Filled.Menu,

                contentDescription = "Menu"

            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PR23106SborschikovPR17Theme {
        Greeting()
    }
}