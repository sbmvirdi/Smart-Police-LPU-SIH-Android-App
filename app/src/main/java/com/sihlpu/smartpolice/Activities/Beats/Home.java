package com.sihlpu.smartpolice.Activities.Beats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sihlpu.smartpolice.R;

public class Home extends AppCompatActivity {
    private CardView fircard,StolenRecoveredcard,knowyourpolice,knowyourstate,noc,verifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fircard = findViewById(R.id.fircard);
        StolenRecoveredcard = findViewById(R.id.StolenRecoveredcard);
        knowyourpolice = findViewById(R.id.knowyourpolice);
        knowyourstate = findViewById(R.id.knowyourstate);
        noc = findViewById(R.id.noc);
        verifications = findViewById(R.id.verifications);

        fircard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        StolenRecoveredcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        knowyourpolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Home.this,DutyAllocation.class);
                startActivity(i);
            }
        });

        knowyourstate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        noc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        verifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
