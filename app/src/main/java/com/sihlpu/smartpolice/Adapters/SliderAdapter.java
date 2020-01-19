package com.sihlpu.smartpolice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.sihlpu.smartpolice.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderVH> {

    private Context mContext;

    public SliderAdapter(Context mContext) {
        this.mContext = mContext;
    }



    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public SliderVH onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.slider_row,parent,false);
        return new SliderVH(v);
    }

    @Override
    public void onBindViewHolder(SliderVH viewHolder, int position) {

        switch (position){
            case 0: viewHolder.setData("https://www.shortto.com/imageslider1",position);
                    break;
            case 1: viewHolder.setData("https://www.shortto.com/imageslider1",position);
                    break;
            case 2: viewHolder.setData("https://www.shortto.com/imageslider1",position);
                    break;
        }
    }


    class SliderVH extends SliderViewAdapter.ViewHolder{

        private ImageView imageView;
        private View v;
        private int pos;

         SliderVH(View itemView) {
            super(itemView);
            v = itemView;
            imageView = v.findViewById(R.id.slider_image);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "clicked" + pos, Toast.LENGTH_SHORT).show();
                }
            });

        }

        private void setData(String link,int pos){
            Picasso.get().load(link).placeholder(R.drawable.placeholder).into(imageView);
            this.pos = pos;
        }
    }
}
