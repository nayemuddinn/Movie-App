package com.example.movieappusingmvvm.View.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieappusingmvvm.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView Title,Rating,Release_Date;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);


        imageView=itemView.findViewById(R.id.image);
        Title=itemView.findViewById(R.id.title);
        Rating=itemView.findViewById(R.id.rating);
        Release_Date=itemView.findViewById(R.id.release_date);
    }
}
