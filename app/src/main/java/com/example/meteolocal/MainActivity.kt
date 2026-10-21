package com.example.meteolocal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meteolocal.ui.theme.MeteoLocalTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeteoLocalTheme {
                MeteoLocalApp()
            }
        }
    }
}

@Composable
fun MeteoLocalApp() {
    var localidad by remember {
        mutableStateOf("")
    }
    var mensaje by remember {
        mutableStateOf("Introduce una localidad")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = "MeteoLocal",
                style = MaterialTheme.typography.headlineMedium
            )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = "Consulta el tiempo de cualquier localidad"
        )
        Spacer(
            modifier = Modifier.height(24.dp)
        )
        OutlinedTextField(
            value = localidad,
            onValueChange = {
                nuevoValor: String -> localidad = nuevoValor
            },
            label = {
                Text("Localidad")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Row{
            Button (
                onClick = {
                    if (localidad.isBlank()) {
                        mensaje = "Introduce una localidad"
                    } else {
                        mensaje = "Consulta preparada: $localidad"
                    }
                }
            ) {
                Text("Consultar")
            }
            Spacer(
                modifier = Modifier.width(12.dp)
            )
            Button(
                onClick = {
                    localidad = ""
                    mensaje = "Introduce una localidad"
                }
            ) {
                Text("Limpiar")
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )
        Text (
            text = mensaje
        )

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeteoLocalTheme {
        Greeting("Android")
    }
}