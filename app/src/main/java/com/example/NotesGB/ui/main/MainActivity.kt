package com.example.NotesGB.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.NotesGB.R
import com.example.NotesGB.data.model.Note
import com.example.NotesGB.ui.base.BaseActivity
import com.example.NotesGB.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<List<Note>?, MainViewState>() {

    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override val layoutRes: Int = R.layout.activity_main
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        adapter = MainAdapter { NoteActivity.start(context = this, id = it.id) }

        mainRecycler.adapter = adapter

        fab.setOnClickListener { NoteActivity.start(context = this)  }
    }

    override fun renderData(data: List<Note>?) {
        data?.let { adapter.notes = it }
    }

}