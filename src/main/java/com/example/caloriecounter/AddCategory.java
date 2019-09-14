package com.example.caloriecounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddCategory extends AppCompatActivity {

    Button btStatus, btCancel, btWater, btFood, btExercise, btWeight, btNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_category);
        btStatus = findViewById(R.id.btStatus);
        btWater = findViewById(R.id.btWater);
        btFood = findViewById(R.id.btFood);
        btExercise = findViewById(R.id.btExercise);
        btWeight = findViewById(R.id.btWeight);
        btNotes = findViewById(R.id.btNotes);
        btCancel = findViewById(R.id.btCancel1);

        btStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddCategory.this, MealsGeneral.class);
                startActivity(intent);
            }
        });
        btWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddCategory.this, MealsGeneral.class));
            }
        });
        btFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddCategory.this, Meals.class));
            }
        });
        btExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddCategory.this, MealsGeneral.class));
            }
        });
        btWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddCategory.this, MealsGeneral.class));
            }
        });
        btNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddCategory.this, MealsGeneral.class));
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCategory.this.finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}
