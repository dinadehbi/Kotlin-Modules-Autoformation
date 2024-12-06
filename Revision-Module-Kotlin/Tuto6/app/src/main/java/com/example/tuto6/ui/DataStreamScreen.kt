package com.example.app.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.collectAsState

@Composable
fun DataStream(modifier: Modifier = Modifier) {
    val dataFlow = remember {
        flow {
            for (i in 1..1000) {
                emit("Item $i")
                delay(3000) // Émettre un nouvel élément toutes les 3 secondes
            }
        }
    }

    val data by dataFlow.collectAsState(initial = "Starting...")

    Text(
        text = data,
        style = MaterialTheme.typography.headlineSmall,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DataStreamPreview() {
    DataStream(modifier = Modifier.fillMaxSize())
}
