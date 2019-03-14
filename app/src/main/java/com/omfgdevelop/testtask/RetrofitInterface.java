package com.omfgdevelop.testtask;

import com.omfgdevelop.testtask.model.Building;
import com.omfgdevelop.testtask.model.Cabinet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RetrofitInterface {

    @GET("bit_buildings_data.json")
   public Call<List<Building>> getBuilding(@Header("Authorization")String auth);


    @GET(" ")
    Call<Void> getAuth(@Header("Authorization")String auth);


    @GET("bit_cabinets_data.json")
    public Call<List<Cabinet>> getCabinets(@Header("Authorization")String auth);

}
