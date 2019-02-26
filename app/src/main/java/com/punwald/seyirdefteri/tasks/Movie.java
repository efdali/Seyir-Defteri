package com.punwald.seyirdefteri.tasks;

import com.punwald.seyirdefteri.models.MovieModel;

public interface Movie {

    interface View{

        void showMovie(MovieModel movieModel);

        void onFailed(String message);

    }

    interface Presenter{
        void getMovie(String imdbID);
    }

}
