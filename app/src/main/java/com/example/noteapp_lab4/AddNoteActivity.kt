package com.example.noteapp_lab4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapp_lab4.databinding.ActivityAddNoteBinding
import javax.inject.Inject

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding

    @Inject
    lateinit var viewModelFactory: NoteViewModelFactory
    private val noteViewModel: NoteViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as NoteApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val content = binding.editTextContent.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                val note = Note(title = title, content = content)
                noteViewModel.insert(note)
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}