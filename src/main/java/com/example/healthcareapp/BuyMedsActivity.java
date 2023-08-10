package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedsActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Medicine 1 : Paracetamol", "", "", "", "50"},
                    {"Medicine 2 : Aspirin", "", "", "", "40"},
                    {"Medicine 3 : Amoxicillin", "", "", "", "150"},
                    {"Medicine 4 : Cetirizine", "", "", "", "30"},
                    {"Medicine 5 : Ibuprofen", "", "", "", "60"},
            };

    private String[] package_details = {
            "Used for: Pain and fever\n" +
                    "Dosage: 500mg to 1000mg every 4 to 6 hours\n" +
                    "Side Effects: Nausea, stomach pain",

            "Used for: Pain, fever, inflammation\n" +
                    "Dosage: 300mg to 1000mg every 4 to 6 hours\n" +
                    "Side Effects: Stomach upset, bleeding",

            "Used for: Bacterial infections\n" +
                    "Dosage: 250mg to 500mg every 8 hours\n" +
                    "Side Effects: Diarrhea, nausea, rash",

            "Used for: Allergies\n" +
                    "Dosage: 10mg once daily\n" +
                    "Side Effects: Drowsiness, dry mouth",

            "Used for: Pain, fever, inflammation\n" +
                    "Dosage: 200mg to 400mg every 4 to 6 hours\n" +
                    "Side Effects: Stomach pain, nausea"
    };
    HashMap<String, String> item;
    ArrayList arrayList;
    SimpleAdapter simpleAdapter;
    Button buttoncart, buttonback;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_meds);
        buttoncart = findViewById(R.id.BMDbuttonGOTOCART);
        buttonback = findViewById(R.id.BMDbuttonLback);
        listView = findViewById(R.id.BMDeditTextMultiline);

        buttoncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedsActivity.this, cartBuyMedsActivity.class));
            }
        });


        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedsActivity.this, homeActivity.class));
            }
        });
        arrayList = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" + packages[i][4] + "/-");
            arrayList.add(item);
        }
        simpleAdapter = new SimpleAdapter(this, arrayList,
                R.layout.multilines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.Line_a, R.id.Line_b, R.id.Line_c, R.id.Line_d, R.id.Line_e});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedsActivity.this, BuyMedsDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);

            }
        });

    }
}


