package com.omfgdevelop.testtask.network;

import com.omfgdevelop.testtask.Logger;
import com.omfgdevelop.testtask.RetrofitClient;
import com.omfgdevelop.testtask.abstraction.BaseRequest;
import com.omfgdevelop.testtask.interfaces.BuildingInterface;
import com.omfgdevelop.testtask.model.Building;
import com.omfgdevelop.testtask.presenter.AuthorizationFragmentPresenter;
import com.omfgdevelop.testtask.view.fragments.BuldingFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuildingRequest extends BaseRequest {
    String authHeader;
    BuildingInterface presenter;

    public BuildingRequest(BuldingFragment presenter) {
        this.presenter = presenter;

    }

    @Override
    public void getCredentials() {
        super.getCredentials();
        this.authHeader = super.authHeader;
        Logger.toLog(authHeader);
    }
    public void getBuildings(){
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        Call<List<Building>> call = retrofitClient.getRetrofitInterface().getBuilding(authHeader);
        call.enqueue(new Callback<List<Building>>() {
            @Override
            public void onResponse(Call<List<Building>> call, Response<List<Building>> response) {
                if(response.isSuccessful()) {
                    if(response.code()==200){
                    try {
                        List<Building> buildings = new ArrayList<>();
                        for (int i = 0; i < response.body().size(); i++) {
                            Building building = new Building();
                            building = response.body().get(i);
                            buildings.add(building);
                        }
//                    buildings = response.body();
                        presenter.callback(buildings);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    }else if(response.code()==401){

                    }
                }else {
                    Logger.toLog("error reciving buildings");
                }
            }

            @Override
            public void onFailure(Call<List<Building>> call, Throwable t) {

            }
        });
    }
}
