package com.sihlpu.smartpolice.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.sihlpu.smartpolice.R;

public class LoginActivity extends AppCompatActivity {
EditText username,password;
Button login,signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.button_login);
        signUp=findViewById(R.id.button_signup);
    }
}