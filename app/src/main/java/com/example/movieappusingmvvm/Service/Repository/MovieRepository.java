package com.example.movieappusingmvvm.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.movieappusingmvvm.Service.Model.MovieModel;
import com.example.movieappusingmvvm.Service.Model.Result;
import com.example.movieappusingmvvm.Service.Network.APIservice;
import com.example.movieappusingmvvm.Service.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static Context mcontext;

    private static MovieRepository instance;
    private List<Result> mresult;
   private MovieModel movieModel;
   private  MutableLiveData mLiveData;

    public static MovieRepository getInstance(Context context)
    {
        if(instance==null)
        {
            instance=new MovieRepository();
            mcontext=context;


        }

        return instance;
    }

    public MutableLiveData<List<Result>> getTopRatedMovieList()
    {
        if(mLiveData==null)
        {
            mLiveData=new MutableLiveData();
        }

        APIservice apIservice= RetrofitInstance.getRetrofit().create(APIservice.class);
        Call<MovieModel> call =apIservice.getMovieList();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                 movieModel=response.body();
                 mresult=movieModel.getResults();

                 mLiveData.postValue(mresult);


            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        return mLiveData;
    }

}
