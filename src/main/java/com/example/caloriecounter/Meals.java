package com.example.caloriecounter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Meals extends AppCompatActivity {

    Button btBreakfast, btLunch, btDinner, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        btBreakfast = findViewById(R.id.btBreakfast);
        btLunch = findViewById(R.id.btLunch);
        btDinner = findViewById(R.id.btDinner);
        btCancel = findViewById(R.id.btCancel);

        btBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Meals.this, com.example.caloriecounter.StatusAdapter.class));
            }
        });
        btLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Meals.this, com.example.caloriecounter.Status.class));
            }
        });
        btDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Meals.this, com.example.caloriecounter.Status.class));
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Meals.this.finish();
            }
        });
    }
}
