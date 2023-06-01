package com.example.movieappusingmvvm.Service.Network;

import com.example.movieappusingmvvm.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIservice {


    @GET("3/movie/top_rated?api_key='your_API_key")
    Call<MovieModel>getMovieList();
}
