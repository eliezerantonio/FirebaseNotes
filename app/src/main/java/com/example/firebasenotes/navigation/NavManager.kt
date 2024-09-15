package com.example.firebasenotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.firebasenotes.viewModels.LoginViewModel
import com.example.firebasenotes.viewModels.NotesViewModel
import com.example.firebasenotes.views.login.BlankView
import com.example.firebasenotes.views.login.TabsView
import com.example.firebasenotes.views.notes.AddNotesView
import com.example.firebasenotes.views.notes.HomeView

@Composable
fun NavManager(loginViewModel: LoginViewModel, notesViewModel: NotesViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Blank") {
        composable("Login") {
            TabsView(navController, loginViewModel)
        }
        composable("Home") {
            HomeView(navController, notesViewModel)
        }
        composable("Blank") {
            BlankView(navController)
        }
        composable("AddNoteView") {
            AddNotesView(navController, notesViewModel)
        }
    }

}