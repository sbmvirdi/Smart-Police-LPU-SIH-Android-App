package com.sihlpu.smartpolice.Activities.Citizens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sihlpu.smartpolice.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirActivity extends AppCompatActivity {

    private EditText nameFir,DOB,emailFir,villageFir,distrcitFir;
    private TextView mobilenumbertobe_set,complaintFir;
    private Spinner gender,police_station;
    private String _gender,_policestation;
    private Button firSubmit;
    private FirebaseAuth mAuth;
    private String uid;
    private DatabaseReference mref;
    private String _mob;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir);

        dialog = new ProgressDialog(this);
        dialog.setMessage("please wait...");
        dialog.setCancelable(false);
        dialog.show();
        nameFir = findViewById(R.id.nameFir);
        DOB = findViewById(R.id.DOB);
        emailFir = findViewById(R.id.emailFir);
        villageFir = findViewById(R.id.villageFir);
        distrcitFir = findViewById(R.id.distrcitFir);
        gender = findViewById(R.id.gender);
        firSubmit = findViewById(R.id.firSubmit);
        complaintFir = findViewById(R.id.complaintFir);

        mobilenumbertobe_set = findViewById(R.id.mobilenumbertobe_set);
        police_station = findViewById(R.id.police_station);
        complaintFir = findViewById(R.id.complaintFir);
        mAuth = FirebaseAuth.getInstance();


        uid = mAuth.getCurrentUser().getUid();


        mref = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);


        mref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                 _mob = (String) dataSnapshot.child("mobileno").getValue();
                String _name = (String) dataSnapshot.child("name").getValue();
//                Toast.makeText(FirActivity.this, _mob, Toast.LENGTH_SHORT).show();
                mobilenumbertobe_set.setText("+91 "+_mob);
                nameFir.setText(_name);
                nameFir.setFocusable(false);
                nameFir.setClickable(false);
                dialog.hide();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                dialog.hide();
            }
        });

        List<String> gender_list = new ArrayList<>();
        gender_list.add("Male");
        gender_list.add("Female");
        gender_list.add("Other");

        List<String> policestations = new ArrayList<>();
        policestations.add("Jalandhar Civil lines");
        policestations.add("Jalandhar Cantt");
        policestations.add("Phagwara");
        policestations.add("Kapurthala");

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,policestations);
        police_station.setAdapter(arrayAdapter1);

        police_station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                _policestation = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,gender_list);
        gender.setAdapter(arrayAdapter);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                _gender = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        firSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();

                String name = nameFir.getText().toString().trim();
                String email = emailFir.getText().toString().trim();
                String address = villageFir.getText().toString().trim()+ ","+distrcitFir.getText().toString().trim();
                String complaint = complaintFir.getText().toString().trim();

                String _dob = DOB.getText().toString().trim();
                if (TextUtils.isEmpty(_dob)){
                    DOB.setError("Enter DOB");
                    DOB.requestFocus();
                }else if (TextUtils.isEmpty(nameFir.getText().toString())){
                    nameFir.setError("Enter DOB");
                    nameFir.requestFocus();                }
                else if (TextUtils.isEmpty(email)){
                    emailFir.setError("Enter DOB");
                    emailFir.requestFocus();
                }
                else if (TextUtils.isEmpty(villageFir.getText().toString())){
                    villageFir.setError("Enter DOB");
                    villageFir.requestFocus();
                }else if (TextUtils.isEmpty(distrcitFir.getText().toString())){
                    distrcitFir.setError("Enter DOB");
                    distrcitFir.requestFocus();
                }else if (TextUtils.isEmpty(distrcitFir.getText().toString())){
                    Toast.makeText(FirActivity.this, "name is being fetched", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(complaintFir.getText().toString())){
                    complaintFir.setError("Enter DOB");
                    complaintFir.requestFocus();                }
                else{

                    Map<String,String> map = new HashMap<>();
                    map.put("name",name);
                    map.put("address",address);
                    map.put("dob",_dob);
                    map.put("email",email);
                    map.put("gender",_gender);
                    long time = System.currentTimeMillis();
                    map.put("id",time+"");
                    map.put("mobileno",_mob);
                    map.put("complaint",complaint);
                    map.put("policestation",_policestation);

                    DatabaseReference d = FirebaseDatabase.getInstance().getReference("fir").child(time+"");
                    d.setValue(map);
                    FirActivity.super.onBackPressed();
                    dialog.hide();
                }

            }
        });



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
