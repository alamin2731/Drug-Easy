package com.example.drugeasy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<MainStructure,MainAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainStructure> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainStructure model) {
 holder.fname.setText(model.getName());
 holder.fgeneric.setText(model.getGenericName());
 holder.fbrand.setText(model.getBrand());
        Glide.with(holder.img.getContext()).load(model.getUrl()).placeholder(R.drawable.common_google_signin_btn_icon_dark_focused)
                .circleCrop()
                .error(R.drawable.img33)
                .into(holder.img);



    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);

    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView fname,fgeneric,fbrand;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(CircleImageView)itemView.findViewById(R.id.img1);
            fname=(TextView)itemView.findViewById(R.id.fname);
            fgeneric=(TextView)itemView.findViewById(R.id.fgeneric);
            fbrand=(TextView) itemView.findViewById(R.id.fbrand);
        }
    }
}
