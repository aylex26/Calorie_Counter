package com.example.caloriecounter;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class StatusAdapter extends AppCompatActivity {

    AutoCompleteTextView tvFood;

    public static final String[] FOOD = new String[]{
            "Carne", "Oua", "Mezeluri", "Branzeturi", "Lactate", "Fructe", "Legume", "Nuci si seminte", "Peste", "Grasimi si indulcitori", "Suplimente si batoane", "Conserve",
            "Gustari si dulciuri", "Mancare gatita", "Bauturi Alcoolice"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_adapter);

        tvFood = findViewById(R.id.tvFood);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(StatusAdapter.this, android.R.layout.simple_list_item_1, FOOD);
        tvFood.setAdapter(adapter);
    }
}
