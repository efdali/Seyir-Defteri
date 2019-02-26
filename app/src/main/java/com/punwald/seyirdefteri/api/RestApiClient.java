package com.punwald.seyirdefteri.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {

    private static RestApi restApi;

    public static RestApi getClient() {


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restApi = retrofit.create(RestApi.class);

        return restApi;
    }

}
