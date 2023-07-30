package com.example.infoseeker

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name: EditText = findViewById(R.id.name)
        var age: EditText = findViewById(R.id.age)
        var submit: Button = findViewById(R.id.submit)
        var sumary: TextView = findViewById(R.id.sumary)

        var text1: TextView = findViewById(R.id.textView)
        var text2: TextView = findViewById(R.id.textView2)
        var reset: Button = findViewById(R.id.reset)

        submit.setOnClickListener {
            PerformOperation(name,age,sumary)
            submit.visibility = View.INVISIBLE
            text1.visibility = View.INVISIBLE
            text2.visibility = View.INVISIBLE
            reset.visibility = View.VISIBLE
        }

        reset.setOnClickListener {
            submit.visibility = View.VISIBLE
            text1.visibility = View.VISIBLE
            text2.visibility = View.VISIBLE
            reset.visibility = View.INVISIBLE
            name.visibility = View.VISIBLE
            age.visibility = View.VISIBLE
            sumary.visibility = View.INVISIBLE
        }
    }

    private fun PerformOperation(name:EditText, age:EditText, sumary: TextView){
//        Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
        var Name:String = name.editableText.toString()
        var Age: Int = Integer.parseInt(age.editableText.toString())

        name.visibility = View.INVISIBLE
        age.visibility = View.INVISIBLE

        var Sumary: String = ""

        Sumary+="SUMARY\n\t"
        Sumary+= "Name : $Name\n"
        Sumary+= "Age : $Age"
        sumary.setText(Sumary)
        sumary.visibility = View.VISIBLE
        name.setText("")
        age.setText("")
    }
}