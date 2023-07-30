package com.example.drinksselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public ImageButton coca_cola, thums_up;
    public TextView scoreboard, coca_score, thums_up_score;
    public Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coca_cola = findViewById(R.id.coca_cola);
        thums_up = findViewById(R.id.thums_up);
        scoreboard = findViewById(R.id.scoreBoard);
        coca_score = findViewById(R.id.coca_score);
        thums_up_score = findViewById(R.id.thums_up_score);
        finish = findViewById(R.id.finish);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int coca_final_score = Integer.parseInt(coca_score.getText().toString());
                int thums_up_final_score = Integer.parseInt(thums_up_score.getText().toString());
                if (coca_final_score>thums_up_final_score) scoreboard.setText("COCA-COLA WINS");
                else if (coca_final_score<thums_up_final_score){
                    scoreboard.setText("THUMS-UP WINS");
                }
                else{
                    scoreboard.setText("IT'S A TIE!!!");
                }
            }
        });
        coca_cola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int coca_current = Integer.parseInt(coca_score.getText().toString());
                coca_current++;
                coca_score.setText(Integer.toString(coca_current));
            }
        });
        thums_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thums_up_current = Integer.parseInt(thums_up_score.getText().toString());
                thums_up_current++;
                thums_up_score.setText(Integer.toString(thums_up_current));
            }
        });
    }
}