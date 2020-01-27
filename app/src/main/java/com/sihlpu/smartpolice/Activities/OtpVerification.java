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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sihlpu.smartpolice.Activities.Citizens.MainActivity;
import com.sihlpu.smartpolice.ModelClasses.Aadhaar;
import com.sihlpu.smartpolice.ModelClasses.User;
import com.sihlpu.smartpolice.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OtpVerification extends AppCompatActivity {
    private TextView enterOtp;
    private EditText otp;
    private Button submit;
    private User user;
    private FirebaseAuth mAuth;
    private String OTP;
    private ProgressDialog progressDialog;
    private String view_mobile;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_verification);
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("please wait...");
        progressDialog.setCancelable(false);
        progressDialog.hide();

        user = (User) getIntent().getSerializableExtra("userModel");

        progressDialog.setCancelable(false);
        submit=findViewById(R.id.submit_otp);
        otp=findViewById(R.id.otpsubmission);
        enterOtp=findViewById(R.id.otpsent);

        view_mobile = user.getMobileno().substring(7);
        enterOtp.setText("Please Enter the OTP sent to +91 XXXXXXX"+view_mobile);


        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                String code = phoneAuthCredential.getSmsCode();
                otp.setText(code);
                Intent i = new Intent(OtpVerification.this,MainActivity.class);
                startActivity(i);
                finish();
                DatabaseReference r = FirebaseDatabase.getInstance().getReference("Users");
                r.child(user.getUid()).setValue(user);
                progressDialog.hide();
//                mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()){
//                            user.setUid(mAuth.getCurrentUser().getUid());
//                            DatabaseReference rf = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
//                            rf.setValue(user);
//                            progressDialog.hide();
//                         Intent i = new Intent(OtpVerification.this, LoginActivity.class);
//                        // mAuth.signOut();
//                         startActivity(i);
//                         finish();
//                        }
//                    }
//                });
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                progressDialog.hide();
                Toast.makeText(OtpVerification.this, "verification Failed", Toast.LENGTH_SHORT).show();
                Log.e("Failed Exception",e.getMessage()+"");
                progressDialog.hide();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                OTP = s;
                Log.e("Phone","Code Sent"+s+"\n"+forceResendingToken.toString()+"\n");
                progressDialog.hide();

            }
        };

        PhoneAuthProvider.getInstance().verifyPhoneNumber("+91"+user.getMobileno(),60, TimeUnit.SECONDS,this,mCallback);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                String otp_value = enterOtp.getText().toString().trim();
                if(TextUtils.isEmpty(otp_value)){
                    otp.setError("Enter OTP");
                    otp.requestFocus();
                    progressDialog.hide();
                }
                else if (!hasConnection()){
                    Toast.makeText(OtpVerification.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                }else{


                     DatabaseReference rf = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
                     rf.setValue(user);
                     PhoneAuthCredential credential = PhoneAuthProvider.getCredential(OTP,otp.getText().toString());
//
//                     if (credential.){
//                         Toast.makeText(OtpVerification.this, "correct code", Toast.LENGTH_SHORT).show();
//                     }else{
//                         Toast.makeText(OtpVerification.this, "", Toast.LENGTH_SHORT).show();
//                     }
                     mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                          if (task.isSuccessful()){
                              Intent i = new Intent(OtpVerification.this,LoginActivity.class);
                              mAuth.signOut();
                              startActivity(i);
                              finish();
                              progressDialog.hide();
                          }
                          else {

                              progressDialog.hide();
                              Toast.makeText(OtpVerification.this, "Verification failed!", Toast.LENGTH_SHORT).show();
                          }
                         }
                     });




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

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(this, "complete the process first!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressDialog.dismiss();
    }
}
