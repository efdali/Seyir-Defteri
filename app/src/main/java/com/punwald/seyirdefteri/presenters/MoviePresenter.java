package com.punwald.seyirdefteri.presenters;

import com.punwald.seyirdefteri.api.RestApi;
import com.punwald.seyirdefteri.api.RestApiClient;
import com.punwald.seyirdefteri.models.MovieModel;
import com.punwald.seyirdefteri.tasks.Movie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements Movie.Presenter {

    RestApi restApi;
    Movie.View view;

    public MoviePresenter(Movie.View view){
        this.view=view;
        restApi= RestApiClient.getClient();
    }


    @Override
    public void getMovie(String imdbID) {

        Call<MovieModel> movie=restApi.getMovie(imdbID);
        movie.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                MovieModel movieModel=response.body();
                if (response.isSuccessful()){
                    view.showMovie(movieModel);
                }else{
                    view.onFailed(response.message());
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                view.onFailed(t.getMessage());
            }
        });

    }
}
