package com.punwald.seyirdefteri.ui.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.models.MovieModel;
import com.punwald.seyirdefteri.presenters.CategoryPresenter;
import com.punwald.seyirdefteri.presenters.MoviePresenter;
import com.punwald.seyirdefteri.tasks.Category;
import com.punwald.seyirdefteri.tasks.Movie;
import com.punwald.seyirdefteri.ui.utils.OnSwipeTouchListener;
import com.punwald.seyirdefteri.ui.utils.Snack;
import com.punwald.seyirdefteri.utils.Constants;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment implements Category.View, Movie.View {

    Spinner spinnerType, spinnerCategory;
    ImageButton infoBtn;
    FrameLayout containerLayout;
    ConstraintLayout draggableLayout;
    ProgressDialog progressDialog;

    ArrayAdapter<String> typeAdapter, categoryAdapter;
    String[] types;

    CategoryPresenter categoryPresenter;
    MoviePresenter moviePresenter;
    Context context;

    MovieModel movieModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        categoryPresenter = new CategoryPresenter(this);

        moviePresenter = new MoviePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        context = view.getContext();

        containerLayout = view.findViewById(R.id.containerLayout);
        spinnerType = view.findViewById(R.id.spinnerType);
        spinnerCategory = view.findViewById(R.id.spinnerCategory);
        draggableLayout = view.findViewById(R.id.draggableLayout);
        infoBtn = view.findViewById(R.id.infoBtn);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        categoryPresenter.getCategories();

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putSerializable("movieModel", movieModel);
                Intent intent = new Intent(context, FilmDetailsActivity.class);
                intent.putExtras(args);
                startActivity(intent);
            }
        });

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moviePresenter.setFilmType(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        draggableLayout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            @Override
            public void onSwipeLeft() {
                moviePresenter.getMovie();
            }
        });



    }

    @Override
    public void showSpinner(String[] categoryModels) {

        categoryAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, categoryModels);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        types = getResources().getStringArray(R.array.film_type);

        typeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, types);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(typeAdapter);

    }

    @Override
    public void showMovie(MovieModel movieModel) {
        this.movieModel = movieModel;
        final ImageView img = new ImageView(context);
        Picasso.get().load(Constants.TMDB_IMAGE_URL + movieModel.getPoster()).into(img, new Callback() {
            @Override
            public void onSuccess() {
                draggableLayout.setBackgroundDrawable(img.getDrawable());
            }

            @Override
            public void onError(Exception e) {

            }
        });


    }

    @Override
    public void showProgressDialog() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Film Getiriliyor...");
//        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void closeProgressDialog() {
        if (progressDialog.isShowing())
            progressDialog.cancel();
    }

    @Override
    public void onFailed(String message) {
        Snack.onFail(getActivity(), message);
    }

}
