package com.omfgdevelop.testtask.network;

import com.omfgdevelop.testtask.RetrofitClient;
import com.omfgdevelop.testtask.abstraction.BaseRequest;
import com.omfgdevelop.testtask.interfaces.CabinetFragmentInterface;
import com.omfgdevelop.testtask.model.Cabinet;
import com.omfgdevelop.testtask.view.fragments.CabinetFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CabinetRequest extends BaseRequest {

    String authHeader;
    CabinetFragmentInterface cabinetFragment;

    public CabinetRequest(CabinetFragmentInterface cabinetFragment) {
        this.cabinetFragment = cabinetFragment;
    }

    @Override
    public void getCredentials() {
        super.getCredentials();
        this.authHeader = super.authHeader;

    }
   public void getCabinets(){
       RetrofitClient retrofitClient = RetrofitClient.getInstance();
       Call<List<Cabinet>> call  =retrofitClient.getRetrofitInterface().getCabinets(authHeader);
       call.enqueue(new Callback<List<Cabinet>>() {
           @Override
           public void onResponse(Call<List<Cabinet>> call, Response<List<Cabinet>> response) {
               if (response.isSuccessful()){
                   if (response.code()==200){
                       List<Cabinet>cabinets = new ArrayList<>();
                       cabinets = response.body();
                       cabinetFragment.callback(cabinets);
                   }else{

                   }
               }else {

               }
           }

           @Override
           public void onFailure(Call<List<Cabinet>> call, Throwable t) {

           }
       });

    }
}
