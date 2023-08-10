package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences pref = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = pref.getString("username", "").toString();
        Toast.makeText(this, "WELCOME"+ username, Toast.LENGTH_SHORT).show();
        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edito = pref.edit();
                edito.clear();
                edito.apply();
                startActivity(new Intent(homeActivity.this,loginActivity.class));
            }
        });
        CardView findDoc = findViewById(R.id.cardFindDoc);
        findDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeActivity.this,FindDocActivity.class));
            }
        });
        CardView lab = findViewById(R.id.cardLabTest);
        lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeActivity.this,labActivity.class));
            }
        });
        CardView orderDetails = findViewById(R.id.cardOrderDetails);
        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeActivity.this,OrderDetailsActivity.class));
            }
        });
        CardView buyMeds = findViewById(R.id.cardBuyMeds);
        buyMeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeActivity.this,BuyMedsActivity.class));
            }
        });
        CardView health = findViewById(R.id.cardHealthdoc);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeActivity.this,HealthActivity.class));
            }
        });
    }
}