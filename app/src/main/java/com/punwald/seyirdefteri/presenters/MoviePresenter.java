package com.punwald.seyirdefteri.presenters;

import com.punwald.seyirdefteri.api.RestApi;
import com.punwald.seyirdefteri.api.RestApiClient;
import com.punwald.seyirdefteri.models.MovieModel;
import com.punwald.seyirdefteri.tasks.Movie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements Movie.Presenter {

    public int rowCount;
    RestApi restApi;
    Movie.View view;
    private String filmType = "Film";

    public MoviePresenter(Movie.View view) {
        this.view = view;
        restApi = RestApiClient.getClient();
        getRowCount();
    }

    public void getRowCount() {

        Call<String> call = restApi.getRowCount(this.filmType);
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

    public void setFilmType(String filmType) {
        this.filmType = filmType;
        getRowCount();
        getMovie();
    }


    @Override
    public void getMovie() {

        Call<MovieModel> movie = restApi.getMovie("2", "Anime");
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
            public void onFailure(Call<MovieModel
                    > call, Throwable t) {
                view.onFailed(t.getMessage());
            }
        });

    }

    public String random() {
        return String.valueOf((int) (Math.random() * rowCount + 1));
    }
}
