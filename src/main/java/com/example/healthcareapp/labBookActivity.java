package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class labBookActivity extends AppCompatActivity {
EditText edname, edaddress, edcontanct, edpincode;
Button buttonBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_book);

        edname = findViewById(R.id.labbookFullName);
        edaddress = findViewById(R.id.labbookBookAddress);
        edcontanct = findViewById(R.id.labbookContactNumber);
        edpincode = findViewById(R.id.labbookFees);
        buttonBooking = findViewById(R.id.labbookBookAppointment);
        Intent intent = getIntent();
        String[] price = intent.getStringArrayExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");
        buttonBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username", "").toString();

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontanct.getText().toString(),Integer.parseInt(edpincode.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price[1].toString()),"lab");
                db.removeCart(username, "lab");
                Toast.makeText(getApplicationContext(), "your booking is successful", Toast.LENGTH_LONG).show();
                startActivity(new Intent(labBookActivity.this,homeActivity.class));

            }
        });
    }
}