package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DocDetailsActivity extends AppCompatActivity {
    private String[][] doctorsdetails1 =
            {
                    {"Doctor's Name : Noel Ikotun","Hospital Address : Columbia", "Exp: 10yrs", "Mobile No: 2345432390", "600"},
                    {"Doctor's Name : Gideon Okoroafor","Hospital Address : Halifax", "Exp: 2yrs", "Mobile No: 7654221459", "400"},
                    {"Doctor's Name : Bereket Lagrot","Hospital Address : Brooklyn park", "Exp: 20yrs", "Mobile No: 6793201395", "550"},
                    {"Doctor's Name : Adedapo Adeniyi","Hospital Address : Lahgos", "Exp: 2rs", "Mobile No: 0802356843", "200"},
                    {"Doctor's Name : Okikiola Adedapo","Hospital Address : Turkey", "Exp: 30yrs", "Mobile No: 569430q339", "900"},
            };
    private String[][] doctorsdetails2 =
            {
                    {"Doctor's Name : Maya Gupta","Hospital Address : Bellevue Medical Center", "Exp: 12yrs", "Mobile No: 8765432109", "800"},
                    {"Doctor's Name : Liam Johnson","Hospital Address : St. Vincent's Hospital", "Exp: 3yrs", "Mobile No: 1098765432", "450"},
                    {"Doctor's Name : Sofia Ramirez","Hospital Address : Mercy General Hospital", "Exp: 18yrs", "Mobile No: 7654321098", "700"},
                    {"Doctor's Name : Nathan Thompson","Hospital Address : Memorial Hospital", "Exp: 7yrs", "Mobile No: 2109876543", "500"},
                    {"Doctor's Name : Ava Wilson","Hospital Address : Baptist Medical Center", "Exp: 9yrs", "Mobile No: 5432109876", "600"}
            };
    private String[][] doctorsdetails3 =
            {
                    {"Doctor's Name : Aiden Martinez","Hospital Address : Rosewood Medical Center", "Exp: 4yrs", "Mobile No: 8901234567", "400"},
                    {"Doctor's Name : Harper Anderson","Hospital Address : Pinecrest Hospital", "Exp: 6yrs", "Mobile No: 7654321098", "550"},
                    {"Doctor's Name : Mia Thompson","Hospital Address : Oakwood General Hospital", "Exp: 10yrs", "Mobile No: 1234567890", "650"},
                    {"Doctor's Name : Benjamin Lee","Hospital Address : Maplewood Medical Center", "Exp: 3yrs", "Mobile No: 9876543210", "450"},
                    {"Doctor's Name : Amelia Davis","Hospital Address : Elmwood Community Hospital", "Exp: 8yrs", "Mobile No: 2345678901", "600"}
            };
    private String[][] doctorsdetails4 =
            {
                    {"Doctor's Name : Ethan Cooper","Hospital Address : Willowbrook Medical Center", "Exp: 5yrs", "Mobile No: 8765432109", "500"},
                    {"Doctor's Name : Emma Wilson","Hospital Address : Oakridge General Hospital", "Exp: 2yrs", "Mobile No: 1098765432", "350"},
                    {"Doctor's Name : Noah Thompson","Hospital Address : Cedarwood Medical Center", "Exp: 10yrs", "Mobile No: 2109876543", "600"},
                    {"Doctor's Name : Olivia Anderson","Hospital Address : Birchwood Community Hospital", "Exp: 7yrs", "Mobile No: 5432109876", "550"},
                    {"Doctor's Name : Liam Taylor","Hospital Address : Maplecrest Hospital", "Exp: 9yrs", "Mobile No: 8901234567", "700"}
            };
    private String[][] doctorsdetails5 =
            {
                    {"Doctor's Name : Sophia Hernandez","Hospital Address : Willowbrook Medical Center", "Exp: 6yrs", "Mobile No: 8765432190", "550"},
                    {"Doctor's Name : Jackson Adams","Hospital Address : Oakridge General Hospital", "Exp: 4yrs", "Mobile No: 1029384756", "400"},
                    {"Doctor's Name : Olivia Roberts","Hospital Address : Cedarwood Medical Center", "Exp: 8yrs", "Mobile No: 2109876543", "650"},
                    {"Doctor's Name : Liam Mitchell","Hospital Address : Birchwood Community Hospital", "Exp: 3yrs", "Mobile No: 5432167890", "450"},
                    {"Doctor's Name : Ava Thompson","Hospital Address : Maplecrest Hospital", "Exp: 5yrs", "Mobile No: 8901234567", "600"}
            };
TextView textView;
Button button;
String [][] doctorsdetails ={};
HashMap<String, String> item;
ArrayList arrayList;
SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_details);
        textView = findViewById(R.id.textViewDDtitle);
        button = findViewById(R.id.buttonLback);
        Intent it = getIntent();

        String title = it.getStringExtra("title");
        textView.setText(title);
        if(title.compareTo("Family Physicians")==0)
        doctorsdetails = doctorsdetails1;
        else
            if(title.compareTo("Nutritionist")==0)
        doctorsdetails = doctorsdetails2;
        else
        if(title.compareTo("Dentist")==0)
        doctorsdetails = doctorsdetails3;
        else
        if(title.compareTo("Surgeon")==0)
        doctorsdetails = doctorsdetails4;
        else
            doctorsdetails = doctorsdetails5;


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocDetailsActivity.this,FindDocActivity.class));
            }
        });
        arrayList = new ArrayList();
        for (int i = 0; i<doctorsdetails.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", doctorsdetails[i][0]);
            item.put("Line2", doctorsdetails[i][1]);
            item.put("Line3", doctorsdetails[i][2]);
            item.put("Line4", doctorsdetails[i][3]);
            item.put("Line5", "Cons Fees" + doctorsdetails[i][4] + "/-");
            arrayList.add(item);
        }
        simpleAdapter = new SimpleAdapter(this,arrayList,R.layout.multilines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.Line_a,R.id.Line_b,R.id.Line_c,R.id.Line_d,R.id.Line_e}
                );
        ListView lst = findViewById(R.id.ListViewL);
        lst.setAdapter(simpleAdapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DocDetailsActivity.this,BookAppActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctorsdetails[i][0]);
                it.putExtra("text3", doctorsdetails[i][1]);
                it.putExtra("text4", doctorsdetails[i][3]);
                it.putExtra("text5", doctorsdetails[i][4]);
               startActivity(it);
            }
        });


        }
    }
