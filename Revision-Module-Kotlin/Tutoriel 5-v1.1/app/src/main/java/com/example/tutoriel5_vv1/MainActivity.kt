package com.example.tutoriel5_vv1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Button(onClick = { count++ }, modifier = Modifier.padding(8.dp)) {
        Text("Cliquez : $count")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCounter() {
    MaterialTheme {
        Counter()
    }
}

@Composable
fun InteractiveButton() {
    var count by remember { mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Clics : $count", modifier = Modifier.padding(bottom = 8.dp))
        Button(onClick = { count++ }) {
            Text("Cliquez-moi")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInteractiveButton() {
    MaterialTheme {
        InteractiveButton()
    }
}

@Composable
fun TextInputExample() {
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Entrez un texte") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth()
        )
        Text("Vous avez écrit : $text", modifier = Modifier.padding(top = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextInputExample() {
    MaterialTheme {
        TextInputExample()
    }
}

@Composable
fun InteractiveForm() {
    var name by remember { mutableStateOf("") }
    var isSubscribed by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Votre nom") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Checkbox(checked = isSubscribed, onCheckedChange = { isSubscribed = it })
            Text("Recevoir des notifications", modifier = Modifier.padding(start = 8.dp))
        }
        Button(
            onClick = {
                message = if (isSubscribed) "Bienvenue, $name !" else "Merci $name, cochez pour des notifications."
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Valider")
        }
        if (message.isNotEmpty()) {
            Text(message, modifier = Modifier.padding(top = 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInteractiveForm() {
    MaterialTheme {
        InteractiveForm()
    }
}
