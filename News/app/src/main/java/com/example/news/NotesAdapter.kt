package com.example.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import kotlinx.android.synthetic.main.item_row.view.*

class NotesAdapter(private var list : ArrayList<Notes?>) : RecyclerView.Adapter<NotesAdapter.Noteholder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NotesAdapter.Noteholder {
        context = parent.context
        val inflateview = LayoutInflater.from(context)
            .inflate(R.layout.item_row,parent, false)
        return Noteholder(inflateview)

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: NotesAdapter.Noteholder, p1: Int) {
        val current = list[p1]
            with(p0.itemView)
            {
                texttitle.text = current?.title
                textdes.text = current ?.des

            }

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