package com.example.drugeasy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class FullAdapter extends FirebaseRecyclerAdapter<FullStruct,FullAdapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FullAdapter(@NonNull FirebaseRecyclerOptions<FullStruct> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull FullAdapter.myViewHolder holder, int position, @NonNull FullStruct model) {
        holder.fname.setText(model.getName());
        holder.fgeneric.setText(model.getGenericName());
        holder.price.setText(model.getPrice());
        holder.fsideeffect.setText(model.getSideEffect());
    }

    @NonNull
    @Override
    public FullAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.full_item,parent,false);

        return null;
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView fname,fgeneric,price,fsideeffect;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(CircleImageView)itemView.findViewById(R.id.img1);
            fname=(TextView)itemView.findViewById(R.id.fname);
            fgeneric=(TextView)itemView.findViewById(R.id.fgeneric);
            price=(TextView) itemView.findViewById(R.id.fbrand);
            fsideeffect=(TextView) itemView.findViewById(R.id.fsideeffect);
        }
    }
}
