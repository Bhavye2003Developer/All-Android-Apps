package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var num1: Int = 0;
        var num2: Int = 1;
        var num3: Float
        var num4: Float

        val input1: EditText = findViewById(R.id.input1)
        val input2: EditText = findViewById(R.id.input2)
        val output: TextView = findViewById(R.id.output)
        val add: Button = findViewById(R.id.add)
        val sub: Button = findViewById(R.id.sub)
        val multiply: Button = findViewById(R.id.multiply)
        val divide: Button = findViewById(R.id.divide)

        add.setOnClickListener {
            if (input1.editableText.toString()=="" || input2.editableText.toString()=="") output.setText("Any or Both Fields are empty")
            else {
                num1 = Integer.parseInt(input1.editableText.toString())
                num2 = Integer.parseInt(input2.editableText.toString())
                output.setText("The sum is = ${num1 + num2}")
                Toast.makeText(this, "Thank You for using my app", Toast.LENGTH_SHORT).show()
            }
        }

        sub.setOnClickListener {
            if (input1.editableText.toString()=="" || input2.editableText.toString()=="") output.setText("Any or Both Fields are empty")
            else {
                num1 = Integer.parseInt(input1.editableText.toString())
                num2 = Integer.parseInt(input2.editableText.toString())
                output.setText("The difference is = ${num1 - num2}")
                Toast.makeText(this, "Thank You for using my app", Toast.LENGTH_SHORT).show()
            }
        }
        multiply.setOnClickListener {
            if (input1.editableText.toString()=="" || input2.editableText.toString()=="") output.setText("Any or Both Fields are empty")
            else {
                num1 = Integer.parseInt(input1.editableText.toString())
                num2 = Integer.parseInt(input2.editableText.toString())
                output.setText("The Multiplication is = ${num1 * num2}")
                Toast.makeText(this, "Thank You for using my app", Toast.LENGTH_SHORT).show()
            }
        }
        divide.setOnClickListener {
            if (input1.editableText.toString()=="" || input2.editableText.toString()=="") output.setText("Any or Both Fields are empty")
            else {
                num3 = input1.editableText.toString().toFloat()
                num4 = input2.editableText.toString().toFloat()
                if (num4 == 0f) {
                    output.setText("ZeroDivisionError!!!")
                } else {
                    output.setText("The division is = ${num3 / num4}")
                }
                Toast.makeText(this, "Thank You for using my app", Toast.LENGTH_SHORT).show()
            }
        }
    }
}