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

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model)
    {
        holder.name.setText(model.getName());
        holder.genericName.setText(model.getGenericName());
        holder.brand.setText(model.getBrand());
        holder.mg.setText(model.getMg());
        Glide.with(holder.img.getContext()).load(model.getPurl()).placeholder(R.drawable.common_google_signin_btn_icon_dark_focused)
                .circleCrop()
                .error(R.drawable.img33)
                .into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.add_add,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        TextView name,genericName,mg,brand;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(CircleImageView)itemView.findViewById(R.id.img1);
            mg = (TextView)itemView.findViewById(R.id.mgText);
            name=(TextView)itemView.findViewById(R.id.nametext);
            genericName=(TextView)itemView.findViewById(R.id.genericText);
            brand=(TextView)itemView.findViewById(R.id.brandText);
        }
    }

}
