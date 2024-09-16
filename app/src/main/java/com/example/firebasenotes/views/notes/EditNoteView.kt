package com.example.firebasenotes.views.notes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.firebasenotes.viewModels.NotesViewModel

@Composable

fun EditNoteView(navController: NavController, notesVM: NotesViewModel, idDoc:String){

    LaunchedEffect(Unit) {
        notesVM.getNoteById(idDoc)
    }
    val state = notesVM.state
    Text(state.title)


}