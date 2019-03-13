package com.punwald.seyirdefteri.data.remote;

import com.punwald.seyirdefteri.model.category.CategoryResponse;
import com.punwald.seyirdefteri.model.movie.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("getRowCount.php")
    Call<String> getRowCount(@Query("tur") String tur);

    @GET("getCategories.php")
    Call<List<CategoryResponse>> getCategories();

    @GET("getMovie.php")
    Call<MovieResponse> getMovie(@Query("filmId") int filmId, @Query("filmTur") String filmTur);


}
