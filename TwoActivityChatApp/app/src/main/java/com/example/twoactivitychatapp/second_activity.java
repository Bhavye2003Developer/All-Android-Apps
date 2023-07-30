package com.example.twoactivitychatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class second_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        TextView show_message = findViewById(R.id.show_first_message);
        show_message.setText(intent.getStringExtra("message_key"));

        EditText get_reply = findViewById(R.id.get_reply);
        Button reply = findViewById(R.id.reply);
        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = get_reply.getText().toString();

                //Reply Intent
                Intent replyIntent = new Intent();
                replyIntent.putExtra("reply_key",message);
                setResult(RESULT_OK,replyIntent);
                finish(); // to close this activity and back to mainactivity
            }
        });
    }
}