package com.example.kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.item_row.view.*

class NotesAdapter(private val notes : ArrayList<Notes?>) : RecyclerView.Adapter<NotesAdapter.NoteHolder>()
{
    lateinit var context : Context
    override fun onCreateViewHolder(parent : ViewGroup, p1: Int): NotesAdapter.NoteHolder {
        context = parent.context
        val inflateview = LayoutInflater.from(context)
            .inflate(R.layout.item_row,parent,false)
        return NoteHolder(inflateview )
    }

    override fun getItemCount(): Int  = notes.size

    override fun onBindViewHolder(holder: NotesAdapter.NoteHolder, position: Int) {
        val current = notes[position]
        with(holder.itemView)
        {
            tvtext.text = current?.title
            tvDes.text = current?.description
            tvtime.text = current?.date
        }
    }
    inner class NoteHolder(itemview : View ) : RecyclerView.ViewHolder(itemview)
    {
        init {
            itemview.setOnClickListener {
                Toast.makeText(context, notes[adapterPosition]?.title,Toast.LENGTH_SHORT).show()

            }
        }
    }


}