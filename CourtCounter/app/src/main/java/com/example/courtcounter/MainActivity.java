package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button team_a_two_ptr, team_a_three_ptr, team_a_free_throw, team_b_two_ptr, team_b_three_ptr, team_b_free_throw, reset;
    public TextView team_a_score, team_b_score;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team_a_score = findViewById(R.id.team_a_score);
        team_a_two_ptr = findViewById(R.id.team_a_two_ptr);
        team_a_three_ptr = findViewById(R.id.team_a_three_ptr);
        team_a_free_throw = findViewById(R.id.team_a_free_throw);

        team_b_score = findViewById(R.id.team_b_score);
        team_b_two_ptr = findViewById(R.id.team_b_two_ptr);
        team_b_three_ptr = findViewById(R.id.team_b_three_ptr);
        team_b_free_throw = findViewById(R.id.team_b_free_throw);

        reset = findViewById(R.id.reset);

        String orange_color = "#C6951B";

        team_a_two_ptr.setBackgroundColor(Color.parseColor(orange_color));
        team_a_three_ptr.setBackgroundColor(Color.parseColor(orange_color));
        team_a_free_throw.setBackgroundColor(Color.parseColor(orange_color));

        team_b_two_ptr.setBackgroundColor(Color.parseColor(orange_color));
        team_b_three_ptr.setBackgroundColor(Color.parseColor(orange_color));
        team_b_free_throw.setBackgroundColor(Color.parseColor(orange_color));

        reset.setBackgroundColor(Color.parseColor(orange_color));

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team_a_score.setText("0");
                team_b_score.setText("0");
            }
        });
        team_a_two_ptr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int team_a_final = Integer.parseInt(team_a_score.getText().toString());
                team_a_final+=2;
                team_a_score.setText(Integer.toString(team_a_final));
            }
        });
        team_a_three_ptr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int team_a_final = Integer.parseInt(team_a_score.getText().toString());
                team_a_final+=3;
                team_a_score.setText(Integer.toString(team_a_final));
            }
        });
        team_a_free_throw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int team_a_final = Integer.parseInt(team_a_score.getText().toString());
                team_a_final+=1;
                team_a_score.setText(Integer.toString(team_a_final));
            }
        });

        team_b_two_ptr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int team_b_final = Integer.parseInt(team_b_score.getText().toString());
                team_b_final+=2;
                team_b_score.setText(Integer.toString(team_b_final));
            }
        });
        team_b_three_ptr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int team_b_final = Integer.parseInt(team_b_score.getText().toString());
                team_b_final+=3;
                team_b_score.setText(Integer.toString(team_b_final));
            }
        });
        team_b_free_throw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int team_b_final = Integer.parseInt(team_b_score.getText().toString());
                team_b_final+=1;
                team_b_score.setText(Integer.toString(team_b_final));
            }
        });
    }
}