package com.example.caloriecounter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MyInfo extends AppCompatActivity {

    Button btCancel, btAddWeight;
    EditText edProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        btCancel = findViewById(R.id.btCancel);
        btAddWeight = findViewById(R.id.btWeight);
        edProgress = findViewById(R.id.edProgress);


        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyInfo.this.finish();
            }
        });
    }
}
