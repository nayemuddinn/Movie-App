package com.example.movieappusingmvvm.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieappusingmvvm.R;
import com.example.movieappusingmvvm.Service.Model.Result;

import java.util.List;

public class movieAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private List<Result> mList;

    public movieAdapter(Context context, List<Result> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_child, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Title.setText(mList.get(position).getTitle());
        holder.Rating.setText(mList.get(position).getVoteAverage().toString());
        holder.Release_Date.setText(mList.get(position).getReleaseDate());

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+mList.get(position).getPosterPath()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        if(this.mList!=null)
        return mList.size();
        else
            return 0;
    }
}


