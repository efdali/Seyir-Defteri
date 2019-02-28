package com.punwald.seyirdefteri.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.models.MovieModel;
import com.punwald.seyirdefteri.presenters.CategoryPresenter;
import com.punwald.seyirdefteri.presenters.MoviePresenter;
import com.punwald.seyirdefteri.tasks.Category;
import com.punwald.seyirdefteri.tasks.Movie;
import com.punwald.seyirdefteri.ui.adapters.FilmAdapter;

public class HomeFragment extends Fragment implements Category.View, Movie.View {

    ViewPager viewPager;
    Spinner spinnerType, spinnerCategory;

    ArrayAdapter<String> typeAdapter, categoryAdapter;
    String[] types;

    CategoryPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        presenter = new CategoryPresenter(this);
        presenter.getCategories();

        viewPager = view.findViewById(R.id.viewPager);
        FilmAdapter adapter = new FilmAdapter();
        viewPager.setAdapter(adapter);

        spinnerType = view.findViewById(R.id.spinnerType);
        spinnerCategory = view.findViewById(R.id.spinnerCategory);


        return view;
    }

    @Override
    public void showSpinner(String[] categoryModels) {

        categoryAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, categoryModels);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        types = getResources().getStringArray(R.array.film_type);

        typeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, types);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(typeAdapter);

    }

    @Override
    public void showMovie(MovieModel movieModel) {
        Log.d("eklendi", movieModel.toString());
    }

    @Override
    public void onFailed(String message) {

    }
}
