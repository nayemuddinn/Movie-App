package com.example.movieappusingmvvm.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movieappusingmvvm.R;
import com.example.movieappusingmvvm.Service.Model.Result;
import com.example.movieappusingmvvm.Service.Repository.MovieRepository;
import com.example.movieappusingmvvm.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieListViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyle);
        mViewModel=new ViewModelProvider(this).get(MovieListViewModel.class);
        mViewModel.getTopRatedMovieLists().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

            }
        });
    }
}