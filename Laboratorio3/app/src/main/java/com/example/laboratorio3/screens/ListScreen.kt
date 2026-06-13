package com.example.laboratorio3.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



@Composable
fun ListScreen() {

    var nombre by remember { mutableStateOf("") }
    val lista = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (nombre.isNotBlank()) {
                    lista.add(nombre)
                    nombre = ""
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text("Listado de nombres y posición en la lista")

            Button(onClick = { lista.clear() }) {
                Text("Limpiar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .border(5.dp, Color.Magenta)
                .padding(10.dp)
        ) {
            itemsIndexed(lista) { index, item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = item)
                    Text(text = "${index + 1}")
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
