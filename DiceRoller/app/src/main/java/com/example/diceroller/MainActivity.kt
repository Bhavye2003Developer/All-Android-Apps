package com.example.diceroller

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var diceImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scrollLinearLayout = findViewById<LinearLayout>(R.id.scrollLinearLayout)
        diceImage = findViewById(R.id.dice)

        val imageArray = intArrayOf(R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4)
        for (index in imageArray.indices){
            val imageView = ImageView(this)
            imageView.setImageResource(imageArray[index])
            val params = LinearLayout.LayoutParams(
                300, // pixels
                300,
                1.0f
            )
            imageView.layoutParams = params
            imageView.setOnClickListener {
                Toast.makeText(this, "${index+1}th image clicked", Toast.LENGTH_SHORT).show()
            }
            scrollLinearLayout.addView(imageView)
        }

        val rollButton = findViewById<Button>(R.id.roll)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val diceId = when((1..6).random()){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceId)
    }
}