package com.sihlpu.smartpolice.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sihlpu.smartpolice.Activities.Citizens.MainActivity;
import com.sihlpu.smartpolice.R;

public class LoginActivity extends AppCompatActivity {
    private EditText username,password;
    private Button login;
    private TextView signup_text;
    private FirebaseAuth mAuth;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.button_login);
        signup_text =findViewById(R.id.signup_text);

        progress = new ProgressDialog(this);
        progress.setMessage("Please wait while we log you in");
        progress.hide();
        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null){
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String email = username.getText().toString().trim();
               String pass = password.getText().toString().trim();
               if(TextUtils.isEmpty(email)&& TextUtils.isEmpty(pass)){
                   Toast.makeText(LoginActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
               }else if (TextUtils.isEmpty(email)){
                   username.setError("Enter Email");
                   username.requestFocus();
               }else if (TextUtils.isEmpty(pass)){
                   password.setError("Enter Password");
                   password.requestFocus();
               }else if (pass.length() <8){
                  password.setError("Password Length less than 8");
                  password.requestFocus();
               }
               else if (!hasConnection()){
                   Toast.makeText(LoginActivity.this, "No internet Connection", Toast.LENGTH_SHORT).show();
               }
               else{
                   progress.show();
                   mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                          if (task.isSuccessful()){
                              progress.dismiss();
                              Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                              Intent i = new Intent(LoginActivity.this,MainActivity.class);
                              startActivity(i);
                              finish();
                          }
                          else{
                              progress.dismiss();
                              Toast.makeText(LoginActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                          }
                       }
                   });
               }
           }
       });


        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean hasConnection() {
        ConnectivityManager cm = (ConnectivityManager) getApplication().getApplicationContext().getSystemService(
                Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }

        NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }

        return false;
    }
}
