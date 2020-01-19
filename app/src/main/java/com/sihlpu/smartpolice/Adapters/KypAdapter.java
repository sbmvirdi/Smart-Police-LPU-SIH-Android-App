package com.sihlpu.smartpolice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sihlpu.smartpolice.Activities.Citizens.policestation;
import com.sihlpu.smartpolice.R;

import java.util.List;

public class KypAdapter extends BaseAdapter {
    private List<policestation> list;
    private Context mcontext;


    public KypAdapter(List<policestation> list, Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.police_row,parent,false);
        TextView state=view.findViewById(R.id.state);
        TextView district=view.findViewById(R.id.district);
        TextView nameofstation=view.findViewById(R.id.nameofstation);
        TextView mail=view.findViewById(R.id.mailofstation);
        TextView inspector=view.findViewById(R.id.inspectorofstation);
        TextView phone=view.findViewById(R.id.phoneofstation);
        TextView constable=view.findViewById(R.id.constable_no);
        TextView subInspector=view.findViewById(R.id.sub_inspector_no);
        policestation policestation=list.get(position);
        state.setText(policestation.getState());
        district.setText(policestation.getDistrict());
        nameofstation.setText(policestation.getNameofStation());
        mail.setText(policestation.getMail());
        inspector.setText(policestation.getInspector_name());
        phone.setText(policestation.getPhone());
        constable.setText(policestation.getNo_of_constables());
        subInspector.setText(policestation.getNo_of_subinspecter());
        return view;
    }
}
