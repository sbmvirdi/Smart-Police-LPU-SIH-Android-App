package com.sihlpu.smartpolice.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(username.getText().toString().isEmpty()||password.getText().toString().isEmpty()){
                   Toast.makeText(LoginActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
               }
           }
       });
    }
}
