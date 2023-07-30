package com.example.androidflavors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Flavors> flavor = new ArrayList<Flavors>();
//        flavor.add(new Flavors("CupCake","1.5"));
//        flavor.add(new Flavors("Donut","1.6"));
//        flavor.add(new Flavors("Eclair","2.0"));
//        flavor.add(new Flavors("Froyo","2.2"));
//        flavor.add(new Flavors("GingerBread","2.3"));
//        flavor.add(new Flavors("HoneyComb","3.0"));

        flavor.add(new Flavors("CupCake","1.5",R.drawable.cupcake));
        flavor.add(new Flavors("Donut","1.6",R.drawable.donut));
        flavor.add(new Flavors("Eclair","2.0",R.drawable.eclair));
        flavor.add(new Flavors("Froyo","2.2",R.drawable.froyo));
        flavor.add(new Flavors("GingerBread","2.3",R.drawable.gingerbread));
        flavor.add(new Flavors("HoneyComb","3.0",R.drawable.honeycomb));

        AndroidFlavorAdapter adapter = new AndroidFlavorAdapter(this, flavor);
        ListView rootView = findViewById(R.id.ListRootView);
        rootView.setAdapter(adapter);
    }
}