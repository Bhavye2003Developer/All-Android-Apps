package com.example.myself;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView linkedin = findViewById(R.id.linkedin);
        ImageView github = findViewById(R.id.github);
        TextView name = findViewById(R.id.name);
        View root = findViewById(R.id.root);
//        root.setBackgroundResource(R.color.white);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetLink("https://www.linkedin.com/in/bhavye-jain-201265217");
            }
        });
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetLink("https://github.com/Bhavye2003Developer");
            }
        });
        final String[] root_theme = {"black"};
        Button theme = findViewById(R.id.theme);
        theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (root_theme[0] =="black"){
                    root.setBackgroundResource(R.color.white);
                    name.setTextColor(Color.parseColor("#000000"));
                    github.setImageResource(R.drawable.githubemb);
                    root_theme[0] = "white";
                }
                else if (root_theme[0]=="white"){
                    root.setBackgroundResource(R.color.black);
                    name.setTextColor(Color.parseColor("#FFFFFF"));
                    github.setImageResource(R.drawable.github_white);
                    root_theme[0] = "black";
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_res, menu);
//        return true;
//    }


    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
//        return super.onCreatePanelMenu(featureId, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_res,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.theme_item:
                Toast.makeText(this, "Change theme", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void GetLink(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
//        String url = "https://www.google.com";
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}