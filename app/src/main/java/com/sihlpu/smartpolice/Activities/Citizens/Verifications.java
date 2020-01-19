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
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.sihlpu.smartpolice.ModelClasses.NocModel;
import com.sihlpu.smartpolice.ModelClasses.Stolen;
import com.sihlpu.smartpolice.R;

public class Verifications extends AppCompatActivity {

    private RecyclerView approvalrec;
    private Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifications);
        approvalrec = findViewById(R.id.approvalrec);
        approvalrec.setLayoutManager(new LinearLayoutManager(this));

        query = FirebaseDatabase.getInstance().getReference("noc").orderByChild("id");

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<NocModel>().setQuery(query, NocModel.class).build();
        FirebaseRecyclerAdapter<NocModel,viewHolder> adapter = new FirebaseRecyclerAdapter<NocModel, viewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull NocModel model) {
                holder.setData(model.getName(),model.getId(),model.getMobile(),model.getAddress(),model.getStatus(),model.getTypeofnoc());
            }

            @NonNull
            @Override
            public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.approvals_row,parent,false);
                return new viewHolder(v);
            }
        };



        approvalrec.setAdapter(adapter);
        try {
            adapter.startListening();
        }catch (Exception e){
            Log.e("Adapter",e.getMessage());
        }




    }

    class viewHolder extends RecyclerView.ViewHolder{
        private TextView name,id,mobile,address,status,typeofnoc;
        View v;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            v =itemView;
            name = v.findViewById(R.id.name);
            id = v.findViewById(R.id.id);
            mobile = v.findViewById(R.id.mobile);
            address = v.findViewById(R.id.address);
            status = v.findViewById(R.id.status);
            typeofnoc = v.findViewById(R.id.typeofnoc);
        }

        void setData(String name,String id,String mobile,String address,String status,String typeofnoc){
            this.name.setText(name);
            this.id.setText(id);
            this.mobile.setText(mobile);
            this.address.setText(address);
            this.typeofnoc.setText(typeofnoc);

            if (status.equals("0")){
                this.status.setText("pending");
                this.status.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                this.status.setTextColor(getResources().getColor(R.color.md_white_1000));
            }else if (status.equals("1")){
                this.status.setText("approved");
                this.status.setBackgroundColor(getResources().getColor(R.color.green));
                this.status.setTextColor(getResources().getColor(R.color.md_white_1000));
            }


        }
    }
}
