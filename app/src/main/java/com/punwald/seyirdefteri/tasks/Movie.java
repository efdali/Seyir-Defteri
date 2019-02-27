package com.punwald.seyirdefteri.tasks;

import com.punwald.seyirdefteri.models.MovieModel;

import java.util.List;

public interface Movie {

    interface View{

        void showMovie(MovieModel movieModel);

        void onFailed(String message);

    }

    interface Presenter{
        void getMovie();
    }

}
