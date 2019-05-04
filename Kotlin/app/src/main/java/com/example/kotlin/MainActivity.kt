package com.example.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_row.*
import kotlinx.android.synthetic.main.linear_dialog.view.*

class MainActivity() : AppCompatActivity() {
    private val notes = ArrayList<Notes?>()

    private val notesadapter = NotesAdapter(notes)
    private val dialogview by lazy{
        layoutInflater.inflate(R.layout.linear_dialog,null,false)

    }
    private val notealert by lazy{
        AlertDialog.Builder(this)
            .setTitle("Enter your name")
            .setView(dialogview)
            .setPositiveButton("Save")
            {
                dialog, _ ->
                val note = Notes(
                    dialogview.ettitle.text.toString(),
                    dialogview.etdes.text.toString(),
                    System.currentTimeMillis().toString()
                )
                saveNotetoFirebase(note)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel"){
                dialog, which ->
                dialog.dismiss()
            }
            .create()
    }


    private fun saveNotetoFirebase(note: Notes) {
        val firebaseDatabase =  FirebaseDatabase.getInstance()
        val rootdatabase = firebaseDatabase.reference
        val childeReference = rootdatabase.push()
        childeReference.setValue(note)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lvnames.layoutManager  = LinearLayoutManager(this)
        lvnames.adapter = notesadapter
        fabnote.setOnClickListener {
            notealert.show()
        }
        FirebaseDatabase.getInstance()
            .reference
            .addChildEventListener(object :ChildEventListener{
                override fun onChildMoved(p0: DataSnapshot, p1: String?) {

                }

                override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                    val note  = p0.getValue(Notes::class.java)
                    notes.add(0,note)
                    notesadapter.notifyItemInserted(0)
                }

                override fun onChildRemoved(p0: DataSnapshot) {
                    val note  = p0.getValue(Notes::class.java)
                    notes.add(note)
                    notesadapter.notifyItemInserted(0)
                }

                override fun onCancelled(p0: DatabaseError) = p0.toException().printStackTrace()
                override fun onChildChanged(ds: DataSnapshot, key: String?) {
                    val updatenote  = ds.getValue(Notes::class.java)
                }

            })
    }





}
