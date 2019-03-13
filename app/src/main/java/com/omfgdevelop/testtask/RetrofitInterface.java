package com.omfgdevelop.testtask;

import com.omfgdevelop.testtask.model.Building;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RetrofitInterface {

    @GET("")
   public Call<Building> getBuilding(@Header("Authorization")String auth);


    @GET(" ")
    Call<Void> getAuth(@Header("Authorization")String auth);
}
