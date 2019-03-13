package com.punwald.seyirdefteri.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.punwald.seyirdefteri.model.movie.MovieResponse;

@Database(entities = {MovieResponse.class}, version = 1,exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    private static volatile MovieDatabase INSTANCE;

    public static MovieDatabase getInstance(Context context) {


        if (INSTANCE == null) {
            synchronized (MovieDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context,
                            MovieDatabase.class,
                            "movie-db")
                            .build();

                }
            }
        }

        return INSTANCE;
    }

    public abstract MovieDao movieDao();


}
