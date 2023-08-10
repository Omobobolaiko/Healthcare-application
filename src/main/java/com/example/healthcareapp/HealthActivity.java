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

public class HealthActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Section 1 : Walking Daily", "", "", "", "Click for more details"},
                    {"Section 2 : COVID-10", "", "", "", "Click for more details"},
                    {"Section 3 : SMOKING", "", "", "", "Click for more details"},
                    {"Section 4 : MENSTRUAL CRAMPS", "", "", "", "Click for more details"},
                    {"Section 5 : Tips to Maintain a Balanced Diet", "", "", "", "Click for more details"},
            };

    private int [] Images = {
 R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5
    };
    HashMap<String, String> item;
    ArrayList arrayList;
    SimpleAdapter simpleAdapter;
    Button buttonback;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        buttonback =findViewById(R.id.btnProceed);
        listView = findViewById(R.id.lProceed);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthActivity.this,homeActivity.class));
            }
        });
        arrayList = new ArrayList();
        for (int i = 0; i<packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][3]);
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
                Intent it = new Intent(HealthActivity.this,HealthDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", Images[i]);

                startActivity(it);

            }
        });

    }
}