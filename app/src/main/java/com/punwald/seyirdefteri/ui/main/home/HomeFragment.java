package com.punwald.seyirdefteri.ui.main.home;


import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.common.BaseFragment;
import com.punwald.seyirdefteri.databinding.FragmentHomeBinding;
import com.punwald.seyirdefteri.model.category.CategoryResponse;
import com.punwald.seyirdefteri.model.movie.MovieResponse;

import java.util.List;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {

    String[] categories;

    String filmTur="Film";

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected Class<HomeViewModel> getViewModel() {
        return HomeViewModel.class;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel.getCategories().observe(this, new Observer<List<CategoryResponse>>() {
            @Override
            public void onChanged(@Nullable List<CategoryResponse> categoryResponses) {
                categories=new String[categoryResponses.size()];
                for (int i=0;i<categoryResponses.size();i++) {
                    categories[i]=categoryResponses.get(i).getCategory();
                }
                dataBinding.setCategories(categories);
            }
        });

        viewModel.getMovie(filmTur).observe(this, new Observer<MovieResponse>() {
            @Override
            public void onChanged(@Nullable MovieResponse movieResponse) {
                dataBinding.homeProgress.setVisibility(View.GONE);
                Log.d("eklendi",movieResponse.getPoster_path()+" poster");
                dataBinding.setMovie(movieResponse);
            }
        });

    }
}
