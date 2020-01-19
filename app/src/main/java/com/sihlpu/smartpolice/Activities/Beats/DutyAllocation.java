package com.sihlpu.smartpolice.Activities.Beats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sihlpu.smartpolice.R;

public class DutyAllocation extends AppCompatActivity {

    private TextView time,date,dutytype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duty_allocation);

        time  = findViewById(R.id.time);
        date = findViewById(R.id.date);
        dutytype = findViewById(R.id.dutytype);
        DatabaseReference d = FirebaseDatabase.getInstance().getReference("policeuser");

        d.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String _date = (String) dataSnapshot.child("Date").getValue();
                String _time  = (String) dataSnapshot.child("time").getValue();
                String _dutytype = (String) dataSnapshot.child("dutytype").getValue();
                time.setText(_time);
                date.setText(_date);
                dutytype.setText(_dutytype);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
