package com.example.movieappusingmvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.movieappusingmvvm.Service.Model.Result;
import com.example.movieappusingmvvm.Service.Repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;

    public MovieListViewModel(@NonNull Application application) {
        super(application);
        movieRepository=MovieRepository.getInstance(application);
    }

    public MutableLiveData<List<Result>> getTopRatedMovieLists()
    {
        return movieRepository.getTopRatedMovieList();
    }
}
