package com.omfgdevelop.testtask.network;

import com.omfgdevelop.testtask.RetrofitClient;
import com.omfgdevelop.testtask.abstraction.BaseRequest;
import com.omfgdevelop.testtask.model.Building;
import com.omfgdevelop.testtask.presenter.AuthorizationFragmentPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuildingRequest extends BaseRequest {
    String authHeader;
    AuthorizationFragmentPresenter presenter;

    public BuildingRequest(AuthorizationFragmentPresenter presenter) {
        this.presenter = presenter;
        this.authHeader = super.authHeader;
    }

    @Override
    public void getCredentials() {
        super.getCredentials();
    }
    public void getBuildings(){
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        Call<Building> call = retrofitClient.getRetrofitInterface().getBuilding(authHeader);
        call.enqueue(new Callback<Building>() {
            @Override
            public void onResponse(Call<Building> call, Response<Building> response) {
                try{
                    Building building = new Building();
                    building = response.body();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Building> call, Throwable t) {

            }
        });
    }
}
