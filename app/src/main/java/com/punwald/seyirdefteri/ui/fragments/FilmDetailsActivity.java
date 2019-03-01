package com.punwald.seyirdefteri.ui.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.models.MovieModel;

public class FilmDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);

        Bundle args = getIntent().getExtras();
        MovieModel movieModel = (MovieModel) args.getSerializable("movieModel");


    }
}
