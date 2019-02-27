package com.punwald.seyirdefteri.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {

    private static final String BASE_URL="http://192.168.2.7/seyir-defteri/";
    private static RestApi restApi;

    public static RestApi getClient() {


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restApi = retrofit.create(RestApi.class);

        return restApi;
    }

}
