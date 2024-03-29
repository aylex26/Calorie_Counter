package com.example.caloriecounter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.midi.MidiDeviceService;
import android.net.InetAddresses;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView tvDatePickerMainActivity;
    Button plusCategory, btInfo, btMyInfo;
    SharedPreferences editor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusCategory = findViewById(R.id.plusAddCategory);
        btInfo = findViewById(R.id.btUpdateGoals);
        btMyInfo = findViewById(R.id.btMyInfo);
        editor = getSharedPreferences("YAS", MODE_PRIVATE);


        //valoarea pe care o ia la primul run de apk
        if (editor.getBoolean("firstRunApp", true)) {
            editor.edit().putString("goals", "2000c").apply();
            editor.edit().putString("greutate", "75").apply();
            editor.edit().putBoolean("firstRunApp", false).apply();
        }

        plusCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCategory.class);
                startActivity(intent);
            }
        });
        btMyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyInfo.class);
                startActivity(intent);
            }
        });
        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.fitness-scandinavia.ro/blog-category/nutritie";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        PieChart pieChart = findViewById(R.id.piechart);

        ArrayList<PieEntry> value = new ArrayList<>();
        value.add(new PieEntry(10f, "breakfast"));
        value.add(new PieEntry(60f, "lunch"));
        value.add(new PieEntry(20f, "dinner"));


        PieDataSet pieDataSet = new PieDataSet(value, "");
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.setClickable(true);
        pieChart.setTouchEnabled(true);
        pieChart.setCenterText("ListView");



//        pieChart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MyInfo.class);
//                Toast.makeText(MainActivity.this, "test1", Toast.LENGTH_SHORT).show();
//            }
//        });


        tvDatePickerMainActivity = findViewById(R.id.tvDatePickerMainActivity);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            }
        };
        tvDatePickerMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            startActivity(getIntent());
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
