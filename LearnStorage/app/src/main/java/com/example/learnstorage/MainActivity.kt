package com.example.learnstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val uniqueID = findViewById<EditText>(R.id.uniqueID)
        val submit = findViewById<Button>(R.id.submit)

        submit.setOnClickListener {
            val data : String = "Name : ${name.editableText.toString()}\nEmail : ${email.editableText.toString()}"
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()

//             saving data into firebase
            val uniqueid = uniqueID.editableText.toString()

            val user = User(name.editableText.toString(), email.editableText.toString(), uniqueid)

            database = FirebaseDatabase.getInstance().getReference("Users")

            database.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User created successfully...", Toast.LENGTH_SHORT).show()
                name.editableText.clear()
                email.editableText.clear()
                uniqueID.editableText.clear()
            }.addOnFailureListener {
                Toast.makeText(this,"Please choose unique ID", Toast.LENGTH_SHORT).show()
            }
        }
    }
}