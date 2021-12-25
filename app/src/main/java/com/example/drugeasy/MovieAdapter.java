package com.example.drugeasy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieVH> {

    private static final String TAG = "MovieAdapter";
    List<Movie> movieList;
int i=0,j=1;
    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MovieVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, int position) {

        Movie movie = movieList.get(position);
        holder.titleTextView.setText(movie.getTitle());
        holder.plotTextView.setText(movie.getPlot());

        boolean isExpanded = movieList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieVH extends RecyclerView.ViewHolder {

        private static final String TAG = "MovieVH";

        ConstraintLayout expandableLayout;
        TextView titleTextView, yearTextView, ratingTextView, plotTextView;
        ImageView arrow;

        public MovieVH(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            plotTextView = itemView.findViewById(R.id.plotTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            arrow=itemView.findViewById(R.id.imageView2);


            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Movie movie = movieList.get(getAdapterPosition());
                    movie.setExpanded(!movie.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                    if(i==0&&j==1){
                        arrow.setImageResource(R.drawable.arrowdown);
                        j=0;
                        i=1;
                    }
                    else if(j==0 && i==1) {
                        arrow.setImageResource(R.drawable.arrowup);
                        j=1;
                        i=0;
                    }

                }
            });

    }
    }
}


