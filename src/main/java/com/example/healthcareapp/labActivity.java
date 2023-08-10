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

public class labActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Package 1 : Full Body Checkup", "", "", "", "999"},
                    {"Package 2 : Blood Glucose Check", "", "", "", "299"},
                    {"Package 3 : COVID 19 Check", "", "", "", "799"},
                    {"Package 4 : Dental Check", "", "", "", "599"},
                    {"Package 5 : Immunity Check", "", "", "", "399"},
            };

    private String[] package_DETAILS = {
            "Blood Glucose Check\n" +
                    "Complete Hemogram\n" +
                    "HbA1c\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "LDH Lactate Dehydrogenase, Serum\n" +
                    "Lipid Profile\n" +
                    "Liver Function Test",
            "Blood Glucose Check",
            "COVID 19 Check",
            "Thyrod Profile-Total(T3, T4 & TSH ULTRA-Sensitive)",
            "Complete Hemograme\n" +
                    "CRP (C Reactive Protein) Quantitative, Serum\n" +
                    "Iron Studies\n" +
                    "Vitamin D Total-25 Hydroxy\n" +
                    "Liver Function Test \n" +
                    "Lipid Profile"
    };
    HashMap <String, String> item;
    ArrayList arrayList;
    SimpleAdapter simpleAdapter;
    Button buttoncart, buttonback;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);
        buttoncart = findViewById(R.id.buttonGOTOCART);
        buttonback =findViewById(R.id.buttonLback);
        listView = findViewById(R.id.ListViewL);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(labActivity.this,homeActivity.class));
            }
        });
        arrayList = new ArrayList();
        for (int i = 0; i<packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" +packages[i][4]+"/-");
            arrayList.add(item);
        }
        simpleAdapter = new SimpleAdapter(this, arrayList,
                R.layout.multilines,
                new String[] {"line1", "line2", "line3", "line4", "line5" },
                new int[] {R.id.Line_a, R.id.Line_b, R.id.Line_c, R.id.Line_d, R.id.Line_e});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(labActivity.this,labDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_DETAILS[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);

            }
        });

        buttoncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(labActivity.this,gotocartActivity.class));
            }
        });
    }
}