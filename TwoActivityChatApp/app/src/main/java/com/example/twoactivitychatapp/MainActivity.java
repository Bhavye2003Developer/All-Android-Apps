package com.example.twoactivitychatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView message_received, show_second_message;
    public EditText get_data;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_to_seccond = findViewById(R.id.send_to_second);

        message_received = findViewById(R.id.textView);

        get_data = findViewById(R.id.second_intent_message_send);

        show_second_message = findViewById(R.id.show_second_message);

        Intent intent = new Intent(this, second_activity.class);
//        Log.v("IMPORTANT",message);
        button_to_seccond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = get_data.getText().toString();
                intent.putExtra("message_key", message);
//                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra("reply_key");
                message_received.setVisibility(View.VISIBLE);
                show_second_message.setText(reply);
                show_second_message.setVisibility(View.VISIBLE);
            }
        }
    }
}