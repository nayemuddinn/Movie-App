package com.example.movieappusingmvvm.Service.Repository;

import android.content.Context;
import android.widget.Toast;

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
            mcontext=context;
            instance=new MovieRepository();



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
        Call<MovieModel> call =apIservice.getTopRatedMovieList();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                 movieModel=response.body();
                 mresult=movieModel.getResults();
                 mLiveData.postValue(mresult);
                Toast.makeText(mcontext,"Success",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(mcontext,"Failed",Toast.LENGTH_SHORT).show();

            }
        });

        return mLiveData;
    }

}
