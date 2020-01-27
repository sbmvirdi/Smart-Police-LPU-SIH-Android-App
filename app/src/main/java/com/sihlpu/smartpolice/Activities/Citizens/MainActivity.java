package com.sihlpu.smartpolice.Activities.Citizens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sihlpu.smartpolice.Activities.Beats.Home;
import com.sihlpu.smartpolice.Activities.LoginActivity;
import com.sihlpu.smartpolice.Adapters.SliderAdapter;
import com.sihlpu.smartpolice.R;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {
    private SliderView mSliderView;
    private FirebaseAuth mAuth;
    private String uid;
    private ProgressDialog dialog;
    private CardView fircard,StolenRecoveredcard,knowyourpolice,knowyourstate,noc,verifications,status,stateservices,womencard,logoutcard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage("Personalizing your dashboard");
        dialog.show();

        if (mAuth.getCurrentUser() == null){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }
        else{
            uid = mAuth.getCurrentUser().getUid();

        }

        Toast.makeText(this, "uid:"+uid, Toast.LENGTH_SHORT).show();



        DatabaseReference d = FirebaseDatabase.getInstance().getReference().child("police");
        d.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isadmin = (boolean) dataSnapshot.child(uid).getValue();
                if (isadmin){
                    Intent i = new Intent(MainActivity.this, Home.class);
                    Log.e("uid",uid);
                    startActivity(i);
                    finish();
                    dialog.hide();
                }
                else {
                    dialog.hide();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                dialog.hide();
            }
        });
        // ids

        fircard = findViewById(R.id.fircard);
        StolenRecoveredcard = findViewById(R.id.StolenRecoveredcard);
        knowyourpolice = findViewById(R.id.knowyourpolice);
        knowyourstate = findViewById(R.id.knowyourstate);
        noc = findViewById(R.id.noc);
        verifications = findViewById(R.id.verifications);
        status = findViewById(R.id.status);
        stateservices = findViewById(R.id.stateservices);
        womencard = findViewById(R.id.womencard);
        logoutcard = findViewById(R.id.logoutcard);

        // click listener

        logoutcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        womencard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,WomenSafety.class);
                startActivity(i);
            }
        });
        fircard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i = new Intent(MainActivity.this,FirActivity.class);
              startActivity(i);
            }
        });

        StolenRecoveredcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,StolenRecovered.class);
                startActivity(i);

            }
        });

        knowyourpolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,KypActivity.class);
                startActivity(i);
            }
        });

        knowyourstate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,kysActivity.class);
                startActivity(i);
            }
        });

        noc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,Noc.class);
                startActivity(i);
            }
        });

        verifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,Verifications.class);
                startActivity(i);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Status.class);
                startActivity(i);

            }
        });

        stateservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,StateServices.class);
                startActivity(i);


            }
        });

        // silder implementation
        mSliderView = findViewById(R.id.imageSlider);
        SliderAdapter adapter = new SliderAdapter(this);
        mSliderView.setSliderAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
