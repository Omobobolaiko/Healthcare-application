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

public class loginActivity extends AppCompatActivity {
EditText eduser, edpass;
Button btn;
TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eduser = findViewById(R.id.editTextLoginUsername);
        edpass = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        text1 = findViewById(R.id.textViewNewUser);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = eduser.getText().toString();
                String password = edpass.getText().toString();
                Database db = new Database(getApplicationContext(),"big b healthcare", null, 1);
                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Fill everything", Toast.LENGTH_SHORT).show();
                } else {
                   if (db.login(username, password)==1) {
                       Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                       SharedPreferences pref = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                       SharedPreferences.Editor editor = pref.edit();
                       editor.putString("username", username);
                       editor.apply();
                       startActivity(new Intent(loginActivity.this, homeActivity.class));
                   }else {
                       Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this, RegistrationActivity.class));
            }
        });

    }
}