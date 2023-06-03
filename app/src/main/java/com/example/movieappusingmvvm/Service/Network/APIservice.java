package com.example.movieappusingmvvm.Service.Network;

import com.example.movieappusingmvvm.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIservice {


    @GET("https://api.themoviedb.org/3/movie/top_rated?api_key=your_Key")
    Call<MovieModel>getTopRatedMovieList();

}
