package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_find_doc);
      CardView exit = findViewById(R.id.cardFBack);
      exit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(FindDocActivity.this,homeActivity.class));
          }
      });
      CardView famPhys = findViewById(R.id.cardFamPhys);
      famPhys.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent it = new Intent(FindDocActivity.this, DocDetailsActivity.class);
              it.putExtra("title", "Family Physicians");
              startActivity(it);
          }
      });

        CardView nutri = findViewById(R.id.cardDietician);
        nutri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DocDetailsActivity.class);
                it.putExtra("title", "Nutritionist");
                startActivity(it);
            }
        });
        CardView dent = findViewById(R.id.cardDentist);
        dent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DocDetailsActivity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });
        CardView surg = findViewById(R.id.cardSurgeon);
       surg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DocDetailsActivity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });
        CardView cardio = findViewById(R.id.cardCardio);
        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DocDetailsActivity.class);
                it.putExtra("title", "Cardiologist");
                startActivity(it);
            }
        });
    }
}