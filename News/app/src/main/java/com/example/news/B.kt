package com.example.news

import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class B : Fragment()
{
    private val notes = ArrayList<Notes?>()
    private val notesadapter = NotesAdapter(notes)
    private val dialogview by lazy {
        layoutInflater.inflate(R.layout.layout_diagnol,null,false)
    }
    private val noteAlert by lazy {

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b,container,false)


    }

}