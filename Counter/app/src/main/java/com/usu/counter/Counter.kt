package com.usu.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Counter() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        var count by remember { mutableStateOf(0) }
        Row() {
            Text("$count")
        }
        Row() {
            Button(onClick = { count -- }) {
                Text(text = "DECREMENT")
            }
            Button(onClick = { count ++ }) {
                Text(text = "Increment")
            }
        }
    }
}