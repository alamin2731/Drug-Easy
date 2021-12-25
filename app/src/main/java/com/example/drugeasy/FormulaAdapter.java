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

public class FormulaAdapter extends RecyclerView.Adapter<FormulaAdapter.ViewHolder>{

    List<FormulaModel> formulaList;
    Context mContext;

    int i=0;
    public FormulaAdapter(Context mContext, List<FormulaModel> formulaList) {
        this.formulaList = formulaList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_formula, parent, false);
        return null; //new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        FormulaModel formula = formulaList.get(position);
        holder.textViewMonth.setText(formula.getName());
        holder.imageViewName.setText(formula.getPic());
        // Picasso.get().load(formula.getPic()).placeholder(R.drawable.cosinerule).error(R.drawable.cosinerule).into(holder.imageViewName);

//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext,holder.textViewMonth.getText(),Toast.LENGTH_SHORT).show();
//            }
//        });

        boolean isExpanded = formulaList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return formulaList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout expandableLayout;
        TextView textViewMonth;
        ImageView arrow;
        TextView imageViewName;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            textViewMonth = itemView.findViewById(R.id.textViewMonth);
            imageViewName = itemView.findViewById(R.id.formulaImage);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            linearLayout =itemView.findViewById(R.id.parent_layout);
            arrow=itemView.findViewById(R.id.imageView);


            textViewMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FormulaModel formula = formulaList.get(getAdapterPosition());
                    formula.setExpanded(!formula.isExpanded());
                    notifyItemChanged(getAdapterPosition());


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
