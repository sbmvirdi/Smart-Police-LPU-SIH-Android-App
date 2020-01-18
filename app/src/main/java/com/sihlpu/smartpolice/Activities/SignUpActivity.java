package com.sihlpu.smartpolice.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.sihlpu.smartpolice.Activities.Citizens.MainActivity;
import com.sihlpu.smartpolice.R;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    private TextView signintext;
    private Button submit;
    private EditText name,email,phone;
    private long gender_value;
    private FirebaseAuth mAuth;
    Spinner gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=findViewById(R.id.userNameSignUp);
        email=findViewById(R.id.userEmailSignup);
        phone=findViewById(R.id.phoneNumber);
        signintext = findViewById(R.id.signin);
        gender=findViewById(R.id.gender);
        submit = findViewById(R.id.submit);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() !=null){
            Intent i = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("Male");
        arrayList.add("Female");
        arrayList.add("Others");
        ArrayAdapter<String>ar= new ArrayAdapter
                <>(this, android.R.layout.simple_list_item_1, arrayList);
        gender.setAdapter(ar);

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender_value = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                gender_value=1;
            }
        });

        signintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _name = name.getText().toString().trim();
                long _gender = gender_value;
                String _email = email.getText().toString().trim();
                String _mobile = phone.getText().toString().trim();

                if (TextUtils.isEmpty(_name) && TextUtils.isEmpty(_email) && TextUtils.isEmpty(_mobile)){
                    Toast.makeText(SignUpActivity.this, "Enter all details", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(_name)){
                    name.setError("Enter name");
                    name.requestFocus();
                }else if (TextUtils.isEmpty(_email)){
                    email.setError("Enter email");
                    email.requestFocus();
                }else if (TextUtils.isEmpty(_mobile)){
                    phone.setError("Enter mobile no");
                    phone.requestFocus();
                }else if (_mobile.length() <8){
                    Toast.makeText(SignUpActivity.this, "Size of password should be greater than 8", Toast.LENGTH_SHORT).show();
                    phone.requestFocus();
                }else if(!hasConnection()){
                    Toast.makeText(SignUpActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
                else {

                }
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
