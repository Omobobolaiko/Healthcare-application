package com.example.healthcareapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class BookAppActivity extends AppCompatActivity {
EditText editText1, editText2,editText3,editText4,editText5;
TextView textView;
private DatePickerDialog datePickerDialog;
private TimePickerDialog timePickerDialog;
private Button dButton, tButton, bookbutton, backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_app);
        textView = findViewById(R.id.textView2);
        editText1 = findViewById(R.id.editTextFullName);
        editText2 = findViewById(R.id.editTextBookAddress);
        editText3 = findViewById(R.id.editTextContactNumber);
        editText4 = findViewById(R.id.editTextFees);
        dButton = findViewById(R.id.buttonAppDate);
        tButton = findViewById(R.id.buttonAppTime);
        bookbutton = findViewById(R.id.buttonBookAppointment);
        backbutton = findViewById(R.id.buttonBookBack);
        editText1.setKeyListener(null);
        editText2.setKeyListener(null);
        editText3.setKeyListener(null);
        editText4.setKeyListener(null);
        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String full = it.getStringExtra("text2");
        String add = it.getStringExtra("text3");
        String cont = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        textView.setText(title);
        editText1.setText(full);
        editText2.setText(add);
        editText3.setText(cont);
        editText4.setText("Cons Fees:" + fees + "/-");
        initDatePicker();
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
        initTimePicker();
        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppActivity.this, FindDocActivity.class));
            }
        });
        bookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dButton.setText(i2 + "/" + i1 + "/" + i);
            }

            };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
       // int style = AlertDialOG.THEME_HOLD_DARK;
        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis()+86400000);



    }
    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

                tButton.setText(i+":"+i1);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int hrs = calendar.get(Calendar.HOUR);
        int mins = calendar.get(Calendar.MINUTE);

        // int style = AlertDialOG.THEME_HOLD_DARK;
        timePickerDialog = new TimePickerDialog(this, timeSetListener, hrs, mins, true);




    }
}