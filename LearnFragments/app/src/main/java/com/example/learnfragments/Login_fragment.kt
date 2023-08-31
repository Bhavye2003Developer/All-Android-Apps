package com.example.learnfragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class Login_fragment : Fragment(R.layout.login_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = view.findViewById<EditText>(R.id.username)
            val password = view.findViewById<EditText>(R.id.password)
            val login = view.findViewById<Button>(R.id.btn_login)

            login.setOnClickListener {
                if (username.editableText.toString()=="Bhavye" && password.editableText.toString()=="12345"){
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
}