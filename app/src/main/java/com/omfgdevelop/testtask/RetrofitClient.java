package com.omfgdevelop.testtask;

import androidx.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Retrofit retrofit;
    private OkHttpClient client;
    private String API_URL = "http://my.guu.ru/json/";
    private RetrofitInterface retrofitInterface;
    String accessToken = null;

    private Retrofit retrofitRefresh = null;

    public RetrofitClient(){
//        API_URL=loadInterface.loadString("server_address",AuthFragmentPresenter.AUTH_FILE);
//Перехватчик ответов сервера, работает тольок при отладочной сборке, здесь исключительно для отладки запросов
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(addInterceptor());
        }
        ;
        client = okHttpBuilder.build();
        if(API_URL==null){
        }else {
            retrofit = new Retrofit.Builder().baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            addToLog("created normal request", "");
            retrofitInterface = retrofit.create(RetrofitInterface.class);
        }
    }

    public static RetrofitClient getInstance(){
        if (instance == null) {
            instance = new RetrofitClient();
        }
        Log.d("RetrofitClient","new instance");
        return instance;
    }
    public Retrofit getAdapterRefresh() {
        if (retrofitRefresh==null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                httpClient.addInterceptor(addInterceptor());
            }

            retrofitRefresh= new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create(addConvertorFactory()))
                    .client(httpClient.build())
                    .build();
        }
        return retrofitRefresh;
    }

    public RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;
    }

    private HttpLoggingInterceptor addInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  loggingInterceptor;
    }

    private Gson addConvertorFactory(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return gson;
    }

    private void addToLog(String comment, String data){
        Log.d("RetrofitClient",comment+" "+data);
    }
}

