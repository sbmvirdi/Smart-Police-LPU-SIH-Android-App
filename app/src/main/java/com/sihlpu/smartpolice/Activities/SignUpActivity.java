package com.sihlpu.smartpolice.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.sihlpu.smartpolice.R;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    EditText name,email,phone;
Spinner gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=findViewById(R.id.userNameSignUp);
        email=findViewById(R.id.userEmailSignup);
        phone=findViewById(R.id.phoneNumber);
        gender=findViewById(R.id.gender);
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("Male");
        arrayList.add("Female");
        arrayList.add("Others");
        ArrayAdapter<String>ar= new ArrayAdapter
                <>(this, android.R.layout.simple_list_item_1, arrayList);
        gender.setAdapter(ar);
    }
}
