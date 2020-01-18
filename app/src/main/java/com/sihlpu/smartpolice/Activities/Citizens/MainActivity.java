package com.sihlpu.smartpolice.Activities.Citizens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.sihlpu.smartpolice.Activities.LoginActivity;
import com.sihlpu.smartpolice.Adapters.SliderAdapter;
import com.sihlpu.smartpolice.R;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {
    private SliderView mSliderView;
    private FirebaseAuth mAuth;
    private String uid;
    private CardView fircard,StolenRecoveredcard,knowyourpolice,knowyourstate,noc,verifications,status,stateservices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()== null){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }
        else{
            uid = mAuth.getCurrentUser().getUid();
        }

        // ids

        fircard = findViewById(R.id.fircard);
        StolenRecoveredcard = findViewById(R.id.StolenRecoveredcard);
        knowyourpolice = findViewById(R.id.knowyourpolice);
        knowyourstate = findViewById(R.id.knowyourstate);
        noc = findViewById(R.id.noc);
        verifications = findViewById(R.id.verifications);
        status = findViewById(R.id.status);
        stateservices = findViewById(R.id.stateservices);


        // click listener
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

                Intent i = new Intent(MainActivity.this,FirActivity.class);
                startActivity(i);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        stateservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        // silder implementation
        mSliderView = findViewById(R.id.imageSlider);
        SliderAdapter adapter = new SliderAdapter(this);
        mSliderView.setSliderAdapter(adapter);
    }
}
