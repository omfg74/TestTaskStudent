package com.omfgdevelop.testtask.network;

import com.omfgdevelop.testtask.RetrofitClient;
import com.omfgdevelop.testtask.abstraction.BaseRequest;
import com.omfgdevelop.testtask.model.CabType;
import com.omfgdevelop.testtask.view.adapters.CabinetAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CabTypeRequest extends BaseRequest {
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

    public void getcabType() {
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        Call<List<CabType>> call = retrofitClient.getRetrofitInterface().getCabType(authHeader);
        call.enqueue(new Callback<List<CabType>>() {
            @Override
            public void onResponse(Call<List<CabType>> call, Response<List<CabType>> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        List<CabType> cabTypes = new ArrayList<>();
                        cabTypes = response.body();
                        cabinetAdapter.callback(cabTypes);
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<CabType>> call, Throwable t) {

            }
        });
    }

}
