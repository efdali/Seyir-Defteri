package com.punwald.seyirdefteri.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.punwald.seyirdefteri.model.movie.MovieResponse;

import java.util.List;

@Dao
public interface MovieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(MovieResponse movieResponse);

    @Delete
    void deleteMovie(MovieResponse movieResponse);

    @Query("Select * from movies")
    LiveData<List<MovieResponse>> getAllMovies();

    @Query("Select * from movies where title = :title")
    LiveData<MovieResponse> getSingleMovie(String title);

}
