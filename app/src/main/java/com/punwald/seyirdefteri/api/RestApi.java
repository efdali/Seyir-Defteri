package com.punwald.seyirdefteri.api;

import com.punwald.seyirdefteri.models.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("?apikey=ab59ac9")
    Call<MovieModel> getMovie(@Query("i") String imdbID);
}
