package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyMedsDetailsActivity extends AppCompatActivity {
    TextView tvpackageName, tvTotalCost;
    EditText edDetails;
    Button buttonaddcart, buttonback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_meds_details);
        tvpackageName = findViewById(R.id.BMDDtextViewPackageName);
        tvTotalCost = findViewById(R.id.BMDDtextViewTotalCost);
        edDetails = findViewById(R.id.BMDDeditTextMultiline);
        buttonaddcart = findViewById(R.id.BMDDbuttonGOTOCART);
        buttonback = findViewById(R.id.BMDDbuttonLback);
        edDetails.setKeyListener(null);
        Intent intent= getIntent();
        tvpackageName.setText(intent.getStringExtra("text1"));

        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedsDetailsActivity.this,BuyMedsActivity.class));
            }
        });
        buttonaddcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = tvpackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());
                Database db = new Database (getApplicationContext(), "healthcare", null,1);
                if (db.checkCart(username, product)==1) {
                    Toast.makeText(getApplicationContext(), "Product Already Added", Toast.LENGTH_SHORT).show();

                } else {
                    db.addCart(username, product, price, "medicine");
                    Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedsDetailsActivity.this,BuyMedsActivity.class));
                }
            }
        });
    }
}