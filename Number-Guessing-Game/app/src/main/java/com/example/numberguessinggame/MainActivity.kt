package com.example.numberguessinggame

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.example.numberguessinggame.R.color.green
import com.example.numberguessinggame.R.id.background
import com.example.numberguessinggame.R.id.textView

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)

    lateinit var background : ConstraintLayout
    lateinit var textView: TextView
    lateinit var btnLeft : Button
    lateinit var btnRight : Button
    lateinit var show_result : Button
    var x = (0..9).random()
    var y = (0..9).random()
    var num_correct : Int = 0
    var num_wrong : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        textView = findViewById(R.id.textView)
        show_result = findViewById(R.id.show_result)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            background = findViewById<ConstraintLayout>(R.id.background)
        }
        if (x==y) {
            x = 1
            y = 2
        }
        btnLeft.setText(x.toString())
        btnRight.setText(y.toString())

        btnLeft.setOnClickListener {
            perform_operation(x,y)
        }
        btnRight.setOnClickListener {
            perform_operation(y,x)
        }
        show_result.setOnClickListener {
            textView.setTextColor(getColor(R.color.white))
            if (num_correct>num_wrong) textView.setText("You Won")
            else if (num_correct<num_wrong){
                textView.setText("You Lost")
            }
            else{
                textView.setText("Draw")
            }
            x = 1
            y = 2
            btnLeft.setText(x.toString())
            btnRight.setText(y.toString())
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                background.setBackgroundColor(getColor(R.color.black))
            }
            num_correct = 0
            num_wrong = 0
        }
    }

    private fun modify_variables() : ArrayList<Int> {
        var arr : ArrayList<Int> = ArrayList()
        x = (0..9).random()
        y = (0..9).random()
        if (x==y) {
            x = 1
            y = 2
        }
        arr.add(x)
        arr.add(y)
        return arr
    }

    @SuppressLint("NewApi")
    fun modify_screen(x : Int, y : Int, right_wrong : Boolean, background_color : Int, num_correct : Int, num_wrong: Int, text_color : Int){
        val text = "Number of right answers : $num_correct\nNumber of wrong answers : $num_wrong"
        background.setBackgroundColor(getColor(background_color))
        textView.setText(text)
        if (right_wrong){
            btnLeft.setText(x.toString())
            btnRight.setText(y.toString())
            Toast.makeText(this,"Right answer",Toast.LENGTH_SHORT).show()
            textView.setTextColor(getColor(text_color))
        }
        else{
            Toast.makeText(this,"Wrong answer",Toast.LENGTH_SHORT).show()
            textView.setTextColor(getColor(text_color))
        }
    }

    fun perform_operation(a : Int, b : Int){
        if (a<b){
            num_correct++
            val arr : ArrayList<Int> = modify_variables()
            x = arr[0]
            y = arr[1]
            modify_variables()
            modify_screen(x,y,true,R.color.green,num_correct,num_wrong,R.color.black)
        }
        else{
            num_wrong++
            modify_screen(x,y,false,R.color.red,num_correct,num_wrong,R.color.white)
        }
    }
}