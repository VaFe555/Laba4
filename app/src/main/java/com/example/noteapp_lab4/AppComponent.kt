package com.example.noteapp_lab4

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(addNoteActivity: AddNoteActivity)

    fun getNoteDao(): NoteDao
}