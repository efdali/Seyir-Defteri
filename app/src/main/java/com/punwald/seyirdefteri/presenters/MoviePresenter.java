package com.punwald.seyirdefteri.presenters;

import android.os.AsyncTask;

import com.punwald.seyirdefteri.api.RestApi;
import com.punwald.seyirdefteri.api.RestApiClient;
import com.punwald.seyirdefteri.models.MovieModel;
import com.punwald.seyirdefteri.tasks.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements Movie.Presenter {

    int rowCount = 2;
    RestApi restApi;
    Movie.View view;
    List<Integer> randoms;
    int num = 0;
    private String filmType = "Film";

    public MoviePresenter(Movie.View view) {
        this.view = view;
        randoms = new ArrayList<>();
        restApi = RestApiClient.getClient();
        getRowCount();
    }

    public void getRowCount() {

        Call<String> call = restApi.getRowCount(this.filmType);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    rowCount = Integer.parseInt(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        num = 0;

    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
        getRowCount();
        getMovie();

    }


    @Override
    public void getMovie() {
        new MovieAsyncTask().execute();
    }

    public String random() {
        Random random = new Random();
        int sayi = random.nextInt(rowCount) + 1;
        boolean check = randoms.contains(sayi);
        if (num != rowCount) {
            while (check) {
                sayi = random.nextInt(rowCount) + 1;
                check = randoms.contains(sayi);
            }
        } else {
            randoms = new ArrayList<>();
        }
        randoms.add(sayi);
        num++;
        return String.valueOf(sayi);
    }

    class MovieAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            view.showProgressDialog();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Call<MovieModel> movie = restApi.getMovie(random(), filmType);
            movie.enqueue(new Callback<MovieModel>() {
                @Override
                public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                    if (response.isSuccessful()) {
                        MovieModel movieModel = response.body();
                        view.showMovie(movieModel);
                    } else {
                        view.onFailed(response.message());
                    }
                    view.closeProgressDialog();
                }

                @Override
                public void onFailure(Call<MovieModel> call, Throwable t) {
                    view.onFailed(t.getMessage());
                    view.closeProgressDialog();
                    getRowCount();
                    getMovie();
                }
            });
            return null;
        }
    }

}
