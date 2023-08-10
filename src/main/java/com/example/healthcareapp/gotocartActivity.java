package com.example.healthcareapp;

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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class gotocartActivity extends AppCompatActivity {
    HashMap<String, String> item;
    ArrayList arrayList;
    SimpleAdapter simpleAdapter;
    ListView listView;
    TextView tvTotal;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, buttonCheckout, buttonBack;
    private String[][] packages ={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gotocart);
        dateButton = findViewById(R.id.gtcbuttondatepicker);
        timeButton = findViewById(R.id.gtcbuttontimepicker);
        buttonBack = findViewById(R.id.gtcback);
        tvTotal = findViewById(R.id.gtctextViewTotalCost);
        listView = findViewById(R.id.gtceditTextMultiline);
        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username", "").toString();
        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
        float totalAmount = 0;
        ArrayList dbData = db.getCartData(username, "lab");

        Toast.makeText(getApplicationContext(), ""+dbData, Toast.LENGTH_LONG).show();
        packages = new String[dbData.size()][];
        for (int i=0; i<packages.length;i++) {
            packages[i] = new String[5];
        }
        for (int i=0; i<dbData.size(); i++) {
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0] = strData[0];
            packages[i][4] = "Cost : " +strData[1] + "/-";
            totalAmount = totalAmount +Float.parseFloat(strData[1]);
        }
        tvTotal.setText("Total Cost: " +totalAmount);

        arrayList = new ArrayList();
        for (int i=0; i<packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]);
            arrayList.add(item);
        }
        simpleAdapter = new SimpleAdapter(this, arrayList,
                R.layout.multilines,
                new String[] {"line1", "line2", "line3", "line4", "line5" },
                new int[] {R.id.Line_a, R.id.Line_b, R.id.Line_c, R.id.Line_d, R.id.Line_e});

        listView.setAdapter(simpleAdapter);

       buttonBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(gotocartActivity.this,labActivity.class));
           }
       });
        buttonCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = (new Intent(gotocartActivity.this,labBookActivity.class));
                it.putExtra("price", tvTotal.getText());
                it.putExtra("date", dateButton.getText());
                it.putExtra("time", timeButton.getText());
                startActivity(it);
            }
        });
       initDatePicker();
       dateButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               datePickerDialog.show();
           }
       });
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
    }
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton.setText(i2 + "/" + i1 + "/" + i);
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

                timeButton.setText(i+":"+i1);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int hrs = calendar.get(Calendar.HOUR);
        int mins = calendar.get(Calendar.MINUTE);

        // int style = AlertDialOG.THEME_HOLD_DARK;
        timePickerDialog = new TimePickerDialog(this, timeSetListener, hrs, mins, true);




    }



}