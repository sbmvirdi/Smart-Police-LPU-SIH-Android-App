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
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.sihlpu.smartpolice.ModelClasses.Stolen;
import com.sihlpu.smartpolice.R;

public class StolenRecovered extends AppCompatActivity {
    private RecyclerView stolenrec;
    private Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stolen_recovered);

        query = FirebaseDatabase.getInstance().getReference("stolenandrecover").orderByChild("article");
        stolenrec = findViewById(R.id.stolenrec);
        stolenrec.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Stolen>().setQuery(query, Stolen.class).build();
        FirebaseRecyclerAdapter<Stolen,viewHolder> adapter = new FirebaseRecyclerAdapter<Stolen, viewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Stolen model) {
            holder.setData(model.getStatus(),model.getArticle(),model.getDescription(),model.getStation());
            }

            @NonNull
            @Override
            public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.lost_row,parent,false);
                return new viewHolder(v);
            }
        };


        stolenrec.setAdapter(adapter);
        try {
            adapter.startListening();
        }catch (Exception e){
            Log.e("Adapter",e.getMessage());
        }

    }

    class viewHolder extends RecyclerView.ViewHolder{
        private TextView status,article,desc,station;
        private View v;

         viewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            status = v.findViewById(R.id.status);
            article = v.findViewById(R.id.article);
            desc = v.findViewById(R.id.desc);
            station = v.findViewById(R.id.station);
        }

        private void setData(String status,String article,String desc,String station){
            this.status.setText(status);
            this.article.setText(article);
            this.desc.setText(desc);
            this.station.setText(station);
        }
    }
}
