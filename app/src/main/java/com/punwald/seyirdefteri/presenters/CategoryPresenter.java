package com.punwald.seyirdefteri.presenters;

import android.os.AsyncTask;

import com.punwald.seyirdefteri.api.RestApi;
import com.punwald.seyirdefteri.api.RestApiClient;
import com.punwald.seyirdefteri.models.CategoryModel;
import com.punwald.seyirdefteri.tasks.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter implements Category.Presenter {

    Category.View view;
    RestApi restApi;

    public CategoryPresenter(Category.View view) {
        this.view = view;
        restApi = RestApiClient.getClient();
    }


    @Override
    public void getCategories() {

        new CategoryAsyncTask().execute();

    }

    class CategoryAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            Call<List<CategoryModel>> call = restApi.getCategories();
            call.enqueue(new Callback<List<CategoryModel>>() {
                @Override
                public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                    if (response.isSuccessful()) {
                        List<CategoryModel> models = response.body();
                        String[] categories=new String[models.size()];

                        for (int i=0;i<models.size();i++){
                            categories[i]=models.get(i).getCategory();
                        }

                        view.showSpinner(categories);
                    }

                }

                @Override
                public void onFailure(Call<List<CategoryModel>> call, Throwable t) {

                }
            });
            return null;
        }
    }
}
