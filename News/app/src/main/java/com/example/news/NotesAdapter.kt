package com.example.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class NotesAdapter(private var list : ArrayList<Notes?>) : RecyclerView.Adapter<NotesAdapter.Noteholder>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NotesAdapter.Noteholder {

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: NotesAdapter.Noteholder, p1: Int) {

    }

    lateinit var context : Context
    inner class Noteholder(itemview : View ) : RecyclerView.ViewHolder(itemview)
    {
        init {
            itemview.setOnClickListener {
                Toast.makeText(context,list[adapterPosition]?.title,Toast.LENGTH_SHORT).show()
            }
        }
    }
}