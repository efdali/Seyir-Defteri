package com.punwald.seyirdefteri.ui.main.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.punwald.seyirdefteri.data.remote.ApiClient;
import com.punwald.seyirdefteri.data.remote.ApiService;
import com.punwald.seyirdefteri.model.category.CategoryResponse;
import com.punwald.seyirdefteri.model.movie.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {

    private ApiService apiService;

    public HomeRepository(){
        apiService= ApiClient.getApiClient();
    }

    public int getRowCount(String filmTur){

        final int[] count = new int[1];
        apiService.getRowCount(filmTur).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                count[0] = Integer.parseInt(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return count[0];
    }

    public LiveData<MovieResponse> getMovie(int filmId,String filmTur){

        final MutableLiveData<MovieResponse> movie=new MutableLiveData<>();
        apiService.getMovie(filmId,filmTur).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movie.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

        return movie;
    }

    public LiveData<List<CategoryResponse>> getCategories(){

        final MutableLiveData<List<CategoryResponse>> movie=new MutableLiveData<>();
        apiService.getCategories().enqueue(new Callback<List<CategoryResponse>>() {
            @Override
            public void onResponse(Call<List<CategoryResponse>> call, Response<List<CategoryResponse>> response) {
                movie.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CategoryResponse>> call, Throwable t) {
                Log.d("eklendi",t.getMessage());
            }
        });

        return movie;
    }


}
