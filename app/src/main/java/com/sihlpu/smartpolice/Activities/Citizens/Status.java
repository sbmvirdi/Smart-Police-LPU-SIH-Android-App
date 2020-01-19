package com.sihlpu.smartpolice.Activities.Citizens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.sihlpu.smartpolice.ModelClasses.FirModel;
import com.sihlpu.smartpolice.ModelClasses.NocModel;
import com.sihlpu.smartpolice.R;

public class Status extends AppCompatActivity {

    private RecyclerView statusrec;
    private Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        statusrec = findViewById(R.id.statusrec);
        statusrec.setLayoutManager(new LinearLayoutManager(this));
        query = FirebaseDatabase.getInstance().getReference("fir").orderByChild("id");
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<FirModel>().setQuery(query, FirModel.class).build();
        FirebaseRecyclerAdapter<FirModel,viewHolder> adapter = new FirebaseRecyclerAdapter<FirModel, viewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull FirModel model) {
                holder.setData(model.getMobileno(),model.getGender(),model.getDob(),model.getComplaint(),model.getAddress(),model.getId());
            }

            @NonNull
            @Override
            public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_row,parent,false);
                return new viewHolder(v);
            }
        };

        statusrec.setAdapter(adapter);
        try {
            adapter.startListening();
        }catch (Exception e){
            Log.e("Adapter",e.getMessage());
        }



    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView mobilevalue,gendervalue,dobvalue,complaintvalue,addressvalue,valueid;

        View v;
         viewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
             mobilevalue = v.findViewById(R.id.mobilevalue);
             gendervalue = v.findViewById(R.id.gendervalue);
             dobvalue = v.findViewById(R.id.dobvalue);
             complaintvalue = v.findViewById(R.id.complaintvalue);
             addressvalue = v.findViewById(R.id.addressvalue);
             valueid = v.findViewById(R.id.valueid);
        }

        void  setData(String mobilevalue,String gendervalue,String dobvalue,String complaintvalue,String addressvalue,String valueid){
             this.mobilevalue.setText(mobilevalue);
            this.gendervalue.setText(gendervalue);
            this.dobvalue.setText(dobvalue);
            this.complaintvalue.setText(complaintvalue);
            this.addressvalue.setText(addressvalue);
            this.valueid.setText(valueid);


        }
    }
}
