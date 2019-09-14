package com.example.caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MealsGeneral extends AppCompatActivity {

    Button btBreakfast, btLunch, btDinner, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_general);

        btBreakfast = findViewById(R.id.btBreakfast1);
        btLunch = findViewById(R.id.btLunch1);
        btDinner = findViewById(R.id.btDinner1);
        btCancel = findViewById(R.id.btCancel1);

        btBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MealsGeneral.this, com.example.caloriecounter.Status.class));
            }
        });
        btLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MealsGeneral.this, com.example.caloriecounter.Status.class));
            }
        });
        btDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MealsGeneral.this, com.example.caloriecounter.Status.class));
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MealsGeneral.this.finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}
