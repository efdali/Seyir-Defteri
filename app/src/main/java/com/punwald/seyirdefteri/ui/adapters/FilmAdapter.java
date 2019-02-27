package com.punwald.seyirdefteri.ui.adapters;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.models.MovieModel;
import com.punwald.seyirdefteri.presenters.MoviePresenter;
import com.punwald.seyirdefteri.tasks.Movie;

public class FilmAdapter extends PagerAdapter implements Movie.View {

    MoviePresenter presenter;
    ConstraintLayout containerL;

    public FilmAdapter() {

//        presenter = new MoviePresenter(this);
//        presenter.getMovie();

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_film, container, false);

        containerL = view.findViewById(R.id.constraintLayout);


        container.addView(view);

        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((View) o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void showMovie(MovieModel movieModel) {
    }

    @Override
    public void onFailed(String message) {

    }
}
