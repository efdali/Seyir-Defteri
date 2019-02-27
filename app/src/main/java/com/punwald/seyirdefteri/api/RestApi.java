package com.punwald.seyirdefteri.api;

import com.punwald.seyirdefteri.models.CategoryModel;
import com.punwald.seyirdefteri.models.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("getRowCount.php")
    Call<String> getRowCount(@Query("tur") int tur);

    @GET("getCategories.php")
    Call<List<CategoryModel>> getCategories();

    @GET("?apikey=ab59ac9")
    Call<MovieModel> getMovie(@Query("i") String imdbID);
}
