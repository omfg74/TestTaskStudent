package com.omfgdevelop.testtask.network;

import com.omfgdevelop.testtask.RetrofitClient;
import com.omfgdevelop.testtask.abstraction.BaseRequest;
import com.omfgdevelop.testtask.model.CabType;
import com.omfgdevelop.testtask.view.adapters.CabinetAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CabTypeRequest  extends BaseRequest {
    CabinetAdapter cabinetAdapter;

    public CabTypeRequest(CabinetAdapter cabinetAdapter) {
        this.cabinetAdapter = cabinetAdapter;
    }

    private String authHeader;
    @Override
    public void getCredentials() {
        super.getCredentials();
        this.authHeader = authHeader;
    }
    public void getcabType(){
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        Call<CabType> call = retrofitClient.getRetrofitInterface().getCabType();
        call.enqueue(new Callback<CabType>() {
            @Override
            public void onResponse(Call<CabType> call, Response<CabType> response) {
                if (response.isSuccessful()){
                    if (response.code()==200){

                    }
                }else {

                }
            }

            @Override
            public void onFailure(Call<CabType> call, Throwable t) {

            }
        });
    }

}
