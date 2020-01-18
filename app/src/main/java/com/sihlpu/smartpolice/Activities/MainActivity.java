package com.sihlpu.smartpolice.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

import com.sihlpu.smartpolice.Adapters.SliderAdapter;
import com.sihlpu.smartpolice.R;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    private SliderView mSliderView;
    private CardView fircard,StolenRecoveredcard,knowyourpolice,knowyourstate,noc,verifications,status,stateservices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSliderView = findViewById(R.id.imageSlider);

        SliderAdapter adapter = new SliderAdapter(this);
        mSliderView.setSliderAdapter(adapter);

    }
}
