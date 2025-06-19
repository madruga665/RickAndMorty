package com.madruga665.rickandmorty.pages.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.madruga665.rickandmorty.components.CharacterRow
import com.madruga665.rickandmorty.models.Character

fun handleCharacterClick(character: Character) {
    println("Character clicked: ${character.name}")
}

@Composable
fun Home(modifier: Modifier = Modifier, homeViewModel: HomeViewModel) {
    val characters = homeViewModel.characters.observeAsState(null)

    LaunchedEffect(Unit) {
        homeViewModel.fetchCharacters()
    }

    if (characters.value === null) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }

    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize().padding(start = 10.dp, end = 10.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
            ) {
            items( characters.value!!.size) { index ->
                CharacterRow(
                    character = characters.value!![index],
                    onClick = { handleCharacterClick(characters.value!![index]) }
                )
            }
        }
    }
}