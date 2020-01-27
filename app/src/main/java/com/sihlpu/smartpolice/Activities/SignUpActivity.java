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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sihlpu.smartpolice.Activities.Citizens.MainActivity;
import com.sihlpu.smartpolice.ModelClasses.Aadhaar;
import com.sihlpu.smartpolice.ModelClasses.User;
import com.sihlpu.smartpolice.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private TextView signintext;
    private Button submit;
    private EditText email,phone,password,aadhaarno;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private Aadhaar aadhaar;
    private List<Aadhaar> mlist;
    private String _uid;
    private DatabaseReference fetchAadhaarData;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        aadhaarno = findViewById(R.id.aadharNumber);
        email=findViewById(R.id.userEmailSignup);
        phone=findViewById(R.id.phoneNumber);
        signintext = findViewById(R.id.signin);
        submit = findViewById(R.id.submit);
        password = findViewById(R.id.password);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait while we send otp");
        progressDialog.hide();
        aadhaar = new Aadhaar();
        mlist = new ArrayList<>();
        fetchAadhaarData = FirebaseDatabase.getInstance().getReference().child("aadhaar");

        mRef = FirebaseDatabase.getInstance().getReference().child("Users");
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() !=null){
            Intent i = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }


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
                progressDialog.show();

                final String _aadhaar = aadhaarno.getText().toString().trim();
                final String _password = password.getText().toString().trim();
                final String _email = email.getText().toString().trim();
                final String _mobile = phone.getText().toString().trim();

                if (TextUtils.isEmpty(_email) && TextUtils.isEmpty(_mobile) && TextUtils.isEmpty(_password)){
                    Toast.makeText(SignUpActivity.this, "Enter all details", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else if (TextUtils.isEmpty(_email)){
                    email.setError("Enter email");
                    email.requestFocus();
                    progressDialog.dismiss();
                }else if (TextUtils.isEmpty(_mobile)){
                    phone.setError("Enter mobile no");
                    phone.requestFocus();
                    progressDialog.dismiss();
                }else if (_mobile.length() <8){
                    Toast.makeText(SignUpActivity.this, "Size of password should be greater than 8", Toast.LENGTH_SHORT).show();
                    phone.requestFocus();
                    progressDialog.dismiss();
                }else if(!hasConnection()){
                    progressDialog.dismiss();
                    Toast.makeText(SignUpActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(_password)){
                    password.setError("Enter Password");
                    password.requestFocus();
                    progressDialog.dismiss();
                }
                else {

//                 mAuth.createUserWithEmailAndPassword(_email,_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                     @Override
//                     public void onComplete(@NonNull Task<AuthResult> task) {
//                         if (task.isSuccessful()) {
//                             String uid = mAuth.getCurrentUser().getUid();
//                             Intent i = new Intent(SignUpActivity.this,OtpVerification.class);
//                             i.putExtra("uid",uid);
//                             i.putExtra("mobileno",_mobile);
//                             i.putExtra("aadhaarno",_aadhaar);
//                             i.putExtra("email",_email);
//                             startActivity(i);
//
//                         }else {
//                             Toast.makeText(SignUpActivity.this, "Failed to Sign Up", Toast.LENGTH_SHORT).show();
//                         }
//
//
//
//                     }
//                 });

                    fetchAadhaarData.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for (DataSnapshot ds:dataSnapshot.getChildren()){
                                Aadhaar aadhaar = ds.getValue(Aadhaar.class);
                                mlist.add(aadhaar);
                            }


                            boolean found=false;
                            for (Aadhaar a : mlist){
                                if (a.getAadharnumber().equals(_aadhaar) && a.getPhone().equals(_mobile) && a.getAvailable().equals("true")){
                                    found =true;
                                    _uid = a.getUid();
                                    aadhaar = a;
                                    break;
                                }
                                else{
                                    found= false;
                                }

                            }
                            if(found){
                                mAuth.createUserWithEmailAndPassword(_email,_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            String uid = mAuth.getCurrentUser().getUid();
                                            User u = new User(_email,uid, aadhaar.getName(),_mobile,aadhaar.getAadharnumber(),aadhaar.getGender(),_uid);
                                            DatabaseReference df = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
                                            DatabaseReference d1 = FirebaseDatabase.getInstance().getReference().child("admin").child(uid);
                                            DatabaseReference d2 = FirebaseDatabase.getInstance().getReference().child("police").child(uid);
                                            d1.setValue(false);
                                            d2.setValue(false);
                                            //df.setValue(u);
                                            DatabaseReference r = FirebaseDatabase.getInstance().getReference().child("aadhaar").child(_uid).child("available");
                                            r.setValue("false");
                                            Intent i = new Intent(SignUpActivity.this,OtpVerification.class);
                                            i.putExtra("userModel",u);
                                            startActivity(i);
                                            finish();
                                            progressDialog.dismiss();
                                        }else{
                                            progressDialog.dismiss();
                                            Toast.makeText(SignUpActivity.this, "failed to signup", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                            else{
                                progressDialog.dismiss();
                                Toast.makeText(SignUpActivity.this, "Enter Correct Data", Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            progressDialog.dismiss();
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
    protected void onDestroy() {
        super.onDestroy();
        progressDialog.dismiss();
    }
}
