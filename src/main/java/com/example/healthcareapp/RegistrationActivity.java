package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText eduser, edem, edpass, edcon;
    Button btn;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        eduser = findViewById(R.id.editTextFullName);
        edpass = findViewById(R.id.editTextContactNumber);
        edem = findViewById(R.id.editTextBookAddress);
        edcon = findViewById(R.id.editTextFees);
        btn = findViewById(R.id.buttonBookAppointment);
        text1 = findViewById(R.id.textViewExistingUser);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, loginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = eduser.getText().toString();
                String password = edpass.getText().toString();
                String email = edem.getText().toString();
                String confirm = edcon.getText().toString();
                Database db = new Database(getApplicationContext(),"big b healthcare", null, 1);
                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Fill everything", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirm) == 0) {
            if (isValid(password)) {
                 db.register(username, email, password);
                Toast.makeText(getApplicationContext(), "New user successful ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegistrationActivity.this, loginActivity.class));
            } else {
                Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, must contain digit, letter and symbol ", Toast.LENGTH_SHORT).show();
            }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and confirm password doesn't match ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public static boolean isValid(String passwordnot){
        int f1=0, f2=0, f3 =0;
        if(passwordnot.length() <8) {
            return false;
        } else {
            for (int a =0; a<passwordnot.length(); a++) {
                if (Character.isLetter(passwordnot.charAt(a))) {
                    f1 = 1;
                }
            }
            for (int b =0; b <passwordnot.length(); b++ ) {
                if (Character.isDigit(passwordnot.charAt(b))) {
                    f2 = 1;
                }
            }
            for (int d =0; d < passwordnot.length(); d++) {
                char c = passwordnot.charAt(d);
                if (c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if (f1==1 && f2 ==1 && f3 ==1)
                return true;
            return false;
        }
    }
}