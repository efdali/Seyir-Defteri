package com.punwald.seyirdefteri.presenters;

import com.punwald.seyirdefteri.api.RestApi;
import com.punwald.seyirdefteri.api.RestApiClient;
import com.punwald.seyirdefteri.models.MovieModel;
import com.punwald.seyirdefteri.tasks.Movie;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements Movie.Presenter {

    RestApi restApi;
    Movie.View view;
    int rowCount;
    private int film_type=1;

    public MoviePresenter(Movie.View view) {
        this.view = view;
        restApi = RestApiClient.getClient();
        getRowCount(film_type);
    }

    public void getRowCount(int film_type) {

        Call<String> call = restApi.getRowCount(film_type);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful())
                    rowCount = Integer.parseInt(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    public void setFilmType(int film_type){
        this.film_type=film_type;
        getRowCount(film_type);
        getMovie();
    }


    @Override
    public void getMovie() {

        Call<MovieModel> movie = restApi.getMovie(random());
        movie.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if (response.isSuccessful()) {
                    MovieModel movieModel = response.body();
                    view.showMovie(movieModel);
                } else {
                    view.onFailed(response.message());
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                view.onFailed(t.getMessage());
            }
        });

    }

    public String random() {
        return String.valueOf(new Random().nextInt(rowCount));
    }
}
