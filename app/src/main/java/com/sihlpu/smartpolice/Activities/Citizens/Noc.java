package com.sihlpu.smartpolice.Activities.Citizens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sihlpu.smartpolice.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Noc extends AppCompatActivity {

    private EditText name,mobile,address;
    private Spinner typeofnoc;
    private Button submitnoc;
    private String _typeofnoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noc);

        name  = findViewById(R.id.name);
        mobile  = findViewById(R.id.mobile);
        address  = findViewById(R.id.address);
        typeofnoc  = findViewById(R.id.typeofnoc);
        submitnoc  = findViewById(R.id.submitnoc);

        List<String> list = new ArrayList<>();
        list.add("for Rally");
        list.add("for VISA");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        typeofnoc.setAdapter(arrayAdapter);
        typeofnoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                _typeofnoc = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        submitnoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _name = name.getText().toString().trim();
                String _mobile = mobile.getText().toString().trim();
                String _address = address.getText().toString().trim();

                if (TextUtils.isEmpty(_name)){
                    name.setError("Enter Name");
                    name.requestFocus();
                }else if (TextUtils.isEmpty(_mobile)){
                    mobile.setError("Enter Mobile");
                    mobile.requestFocus();
                }else if (TextUtils.isEmpty(_address)){
                    address.setError("Enter Mobile");
                    address.requestFocus();
                }else {
                    Map<String,String> map = new HashMap<>();
                    map.put("name",_name);
                    map.put("address",_address);
                    map.put("mobile",_mobile);
                    map.put("typeofnoc",_typeofnoc);
                    map.put("status","0");
                    long time  = System.currentTimeMillis();
                    map.put("id",time+"");
                    DatabaseReference  d = FirebaseDatabase.getInstance().getReference("noc").child(time+"");
                    d.setValue(map);
                    Toast.makeText(Noc.this, "submitted", Toast.LENGTH_SHORT).show();
                    Noc.super.onBackPressed();
                }

            }
        });

    }
}
