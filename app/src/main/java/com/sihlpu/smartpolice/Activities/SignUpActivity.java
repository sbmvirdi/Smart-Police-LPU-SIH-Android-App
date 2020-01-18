package com.sihlpu.smartpolice.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sihlpu.smartpolice.R;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    EditText name, email, phone, aadhar;
    Spinner gender;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.userNameSignUp);
        email = findViewById(R.id.userEmailSignup);
        phone = findViewById(R.id.phoneNumber);
        gender = findViewById(R.id.gender);
        aadhar = findViewById(R.id.aadharNumber);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty() || name.getText().toString().isEmpty()
                        || phone.getText().toString().isEmpty() || aadhar.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please fill all the Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Male");
        arrayList.add("Female");
        arrayList.add("Others");
        ArrayAdapter<String> ar = new ArrayAdapter
                <>(this, android.R.layout.simple_list_item_1, arrayList);
        gender.setAdapter(ar);
    }
}
