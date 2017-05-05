package com.example.suadahaji.gravityview.api;

import com.example.suadahaji.gravityview.utils.Api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by suadahaji
 */

public class ApiModule {

    private ApiManager apiManager;

    public ApiModule() {

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                // Sets the API base url
                .baseUrl(Api.BASE_URL)
                // Converter factory for serialization and deserialization of objects
                .addConverterFactory(GsonConverterFactory.create())
                // Supports service method return types
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        apiManager = retrofit.create(ApiManager.class);

    }

    public ApiManager getApi() {
        return apiManager;
    }

    }

