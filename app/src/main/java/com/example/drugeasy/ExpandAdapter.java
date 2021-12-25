package com.example.drugeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpandAdapter extends RecyclerView.Adapter<ExpandAdapter.ViewHolder>{

    List<ExpandModel> formulaList;
    Context mContext;

    int i=0;
    public ExpandAdapter(Context mContext, List<ExpandModel> formulaList) {
        this.formulaList = formulaList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        ExpandModel formula = formulaList.get(position);
        holder.textViewMonth.setText(formula.getName());
        holder.p.setText(formula.getPic());
        boolean isExpanded = formulaList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return formulaList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout expandableLayout;
        TextView textViewMonth,p;
        ImageView arrow;
        TextView imageViewName;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            textViewMonth = itemView.findViewById(R.id.textViewMonth);
            p=itemView.findViewById(R.id.formulaImage);
            /*
            imageViewName = itemView.findViewById(R.id.formulaImage);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            linearLayout =itemView.findViewById(R.id.parent_layout);
            arrow=itemView.findViewById(R.id.imageView);*/


            textViewMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ExpandModel formula = formulaList.get(getItemCount());
                    formula.setExpanded(!formula.isExpanded());
                    notifyItemChanged(getItemCount());


                    if(i==0){
                        arrow.setImageResource(R.drawable.arrowdown);
                        i=1;
                    }
                    else if(i==1){
                        arrow.setImageResource(R.drawable.arrowup);
                        i=0;
                    }
                }
            });
        }
    }
}