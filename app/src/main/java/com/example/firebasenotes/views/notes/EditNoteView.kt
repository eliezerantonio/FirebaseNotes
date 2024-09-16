package com.example.firebasenotes.views.notes

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firebasenotes.viewModels.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun EditNoteView(navController: NavController, notesViewModel: NotesViewModel, idDoc: String) {

    LaunchedEffect(Unit) {
        notesViewModel.getNoteById(idDoc)
    }
    val state = notesViewModel.state


    var title by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(topBar = {
        TopAppBar(title = { Text("Editar Nota") }, navigationIcon = {
            IconButton(onClick = {

                navController.popBackStack()
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "")
            }
        }, actions = {
            IconButton(onClick = {


                notesViewModel.saveNewNote(title, note) {
                    Toast.makeText(context, "Guardado", Toast.LENGTH_LONG).show()
                    navController.popBackStack()
                }
            }) {

                Icon(Icons.Default.AddCircle, contentDescription = "")
            }
        })
    }

    ) { pad -> Column(
            modifier = Modifier
                .padding(pad)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = state.title,
                onValueChange = { notesViewModel.onValue(it, "title") },
                label = { Text("Titulo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            )


            OutlinedTextField(
                value = state.note,
                onValueChange = { notesViewModel.onValue(it, "note") },
                label = { Text("Nota") },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            )


        }
    }
}