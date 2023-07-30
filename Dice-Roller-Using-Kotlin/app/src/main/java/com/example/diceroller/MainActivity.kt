package com.example.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var random_num : Int = 0;

        val button : Button = findViewById(R.id.button);
        var dice : ImageView = findViewById(R.id.dice);

        button.setOnClickListener() {
//            random_num = get_random_num();
//            Toast.makeText(this,"$random_num",Toast.LENGTH_SHORT).show();
            val drawableResource = when (get_random_num()){
                1 -> R.drawable.dice_1;
                2 -> R.drawable.dice_2;
                3 -> R.drawable.dice_3;
                4 -> R.drawable.dice_4;
                5 -> R.drawable.dice_5;
                else -> R.drawable.dice_6;
            }
            dice.setImageResource(drawableResource);
        }
    }

    private fun get_random_num(): Int {
        return (1..6).random();
    }
}
