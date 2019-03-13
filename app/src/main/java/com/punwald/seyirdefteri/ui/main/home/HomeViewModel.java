package com.punwald.seyirdefteri.ui.main.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.punwald.seyirdefteri.model.category.CategoryResponse;
import com.punwald.seyirdefteri.model.movie.MovieResponse;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private HomeRepository repository;

    public HomeViewModel(){
        repository=new HomeRepository();
    }

    public LiveData<MovieResponse> getMovie(String filmTur){
        return repository.getMovie(random(repository.getRowCount(filmTur)),filmTur);
    }

    public LiveData<List<CategoryResponse>> getCategories(){

        return repository.getCategories();
    }


    public int random(int rowCount) {
        return (int) (Math.random() * rowCount + 1);
    }

}
