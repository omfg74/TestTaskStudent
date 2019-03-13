package com.omfgdevelop.testtask;

import com.omfgdevelop.testtask.abstraction.BaseRequest;
import com.omfgdevelop.testtask.model.Building;
import com.omfgdevelop.testtask.presenter.AuthorizationFragmentPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestRequest extends BaseRequest {
    String authHeader;
    AuthorizationFragmentPresenter presenter;

    public TestRequest(AuthorizationFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getCredentials() {
        super.getCredentials();
        this.authHeader = super.authHeader;
    }

    public void getBuilding() {
    RetrofitClient retrofitClient = RetrofitClient.getInstance();
    Call<Void> call = retrofitClient.getRetrofitInterface().getAuth(authHeader);
    call.enqueue(new Callback<Void>() {

        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            if(response.isSuccessful()) {
                presenter.callback(String.valueOf(response.code()));
            }else {
                presenter.callback(String.valueOf(response.code()));
            }
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {
            presenter.callback(String.valueOf("can not connect to server"));
        }
    });

}
}
