package com.sihlpu.smartpolice.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sihlpu.smartpolice.R;

public class OptVerification extends AppCompatActivity {
    TextView enterOtp;
    EditText otp;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_verification);
        submit=findViewById(R.id.submit_otp);
        otp=findViewById(R.id.otpsubmission);
        enterOtp=findViewById(R.id.otpsent);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enterOtp.getText().toString().isEmpty()){
                    Toast.makeText(OptVerification.this, "Please enter the OTP sent to your phone", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
