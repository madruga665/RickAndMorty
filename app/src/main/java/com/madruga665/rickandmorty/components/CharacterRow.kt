package com.madruga665.rickandmorty.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.madruga665.rickandmorty.models.Character

@Composable
fun CharacterRow(character: Character, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .border(border = BorderStroke(width = 1.dp, color = Color.Black))
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.padding(end = 10.dp),
            model = character.image,
            contentDescription = "Character image"
        )
        Text( text = "Nome ${character.name}", overflow = TextOverflow.Ellipsis)
    }
}