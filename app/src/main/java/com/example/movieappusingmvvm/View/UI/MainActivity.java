package com.example.movieappusingmvvm.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.movieappusingmvvm.R;
import com.example.movieappusingmvvm.Service.Model.Result;
import com.example.movieappusingmvvm.Service.Repository.MovieRepository;
import com.example.movieappusingmvvm.View.Adapter.movieAdapter;
import com.example.movieappusingmvvm.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieListViewModel mViewModel;
    private movieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyle);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mViewModel=new ViewModelProvider(this).get(MovieListViewModel.class);
        mViewModel.getTopRatedMovieLists().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
           adapter=new movieAdapter(MainActivity.this,results);
           recyclerView.setAdapter(adapter);


            }
        });
    }
}