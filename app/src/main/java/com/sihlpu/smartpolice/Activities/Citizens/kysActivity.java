package com.sihlpu.smartpolice.Activities.Citizens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.TreeDataEntry;
import com.anychart.charts.TreeMap;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sihlpu.smartpolice.ModelClasses.punjab;
import com.sihlpu.smartpolice.R;

import java.util.ArrayList;
import java.util.List;

public class kysActivity extends AppCompatActivity {

    private List<punjab> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kys);

        DatabaseReference d = FirebaseDatabase.getInstance().getReference("kys").child("punjab");
        d.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot d: dataSnapshot.getChildren()){
                    punjab p = d.getValue(punjab.class);
                    list.add(p);
                    List<DataEntry>entryList=new ArrayList<>();
                    int value  = (int) p.getTotal();
                    entryList.add(new CustomTreeDataEntry(value,p.getDistrict()));
                }
                AnyChartView anyChartView=findViewById(R.id.chart);
                TreeMap treeMap= AnyChart.treeMap();
                anyChartView.setChart(treeMap);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private class CustomTreeDataEntry extends TreeDataEntry {


        CustomTreeDataEntry(int total, String district) {
            super(total, district);
            setValue("district", district);
        }
    }
}
