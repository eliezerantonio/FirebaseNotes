package com.example.firebasenotes.views.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.firebasenotes.viewModels.NotesViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, notesViewModel: NotesViewModel) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Minhas Notas") },
            navigationIcon = {
                IconButton(onClick = {

                    notesViewModel.logOut()
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "")
                }
            },
            actions = {
                IconButton(onClick = {

                    navController.navigate("AddNoteView")
                }) {
                    Icon(Icons.Default.Add, contentDescription = "")
                }
            }
        )
    }) { pad ->
        Column(
            modifier = Modifier.padding(pad),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


        }


    }


}