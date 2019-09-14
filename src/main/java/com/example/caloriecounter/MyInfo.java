package com.example.caloriecounter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyInfo extends AppCompatActivity {

    Button btCancel, btAddWeight, btUpdateGoals;
    EditText edProgress;
    TextView edGoals;

    SharedPreferences editor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        btCancel = findViewById(R.id.btCancel1);
        btAddWeight = findViewById(R.id.btAddWeight);
        edProgress = findViewById(R.id.edProgress);
        btUpdateGoals = findViewById(R.id.btUpdateGoals);
        edGoals = findViewById(R.id.edGoals);


        //getSharedPreferences pentru a pastra local datele
        // MY_PREFS_NAME - a static String variable like:
        // public static final String MY_PREFS_NAME = "MyPrefsFile";
        editor = getSharedPreferences("YAS", MODE_PRIVATE);

        edProgress.setText(editor.getString("greutate", ""));
        edGoals.setText(editor.getString("goals", ""));


        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyInfo.this.finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        btAddWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                editor.edit().putString("greutate", edProgress.getText().toString().trim()).apply();
                startActivity(getIntent());
                MyInfo.this.finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        btUpdateGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.edit().putString("goals", edGoals.getText().toString().trim()).apply();
                startActivity(getIntent());
                MyInfo.this.finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}
