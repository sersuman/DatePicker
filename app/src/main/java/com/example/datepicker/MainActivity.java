package com.example.datepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvDate, tvResult, tvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tvDate);
        tvResult = findViewById(R.id.tvResult);
        tvTime = findViewById(R.id.tvTime);

        tvDate.setOnClickListener(this);
        tvTime.setOnClickListener(this);
    }
    private void loadDate(){
        //current date as default
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

//        open date picker and set current date as default
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "Year/Month/Day: " + year +"/" + month + "/"+ dayOfMonth;
                tvResult.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }
    private void loadTime(){
//        get current time
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time = hourOfDay+":"+minute;
                tvResult.setText(time);
            }
        },hour,minute,true);
        timePickerDialog.show();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvDate){
            loadDate();
        }if (v.getId() == R.id.tvTime){
            loadTime();
        }
    }
}
