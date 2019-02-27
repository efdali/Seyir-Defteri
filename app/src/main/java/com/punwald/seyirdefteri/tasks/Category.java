package com.punwald.seyirdefteri.tasks;

import com.punwald.seyirdefteri.models.CategoryModel;

import java.util.List;

public interface Category {

    interface View {

        void showSpinner(String[] categoryModels);

    }

    interface Presenter {
        void getCategories();
    }

}
