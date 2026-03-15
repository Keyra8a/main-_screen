package com.example.main_screen.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.main_screen.components.Contact

@Composable
fun ListItenExample(){
    var frutas = listOf("Manzana", "pera", "Naranja", "Mandarina")

    var contacts = listOf(
        Pair("Juan Peres", "612-123-2312"),
        Pair("Juan Peres", "612-123-2312"),
        Pair("Juan Peres", "612-123-2312"),
        Pair("Juan Peres", "612-123-2312"),

    )
   /* LazyColumn() {
        items(contacts){
            contact ->
            Text(
                Contact(contact.first, contact.second)
            )
        }
    }*/
}

@Preview(showBackground = true)
@Composable
fun ListItemsExamplePreview(){
    ListItenExample()
}