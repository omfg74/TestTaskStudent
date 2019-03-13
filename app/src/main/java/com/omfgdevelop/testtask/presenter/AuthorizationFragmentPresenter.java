package com.omfgdevelop.testtask.presenter;

import com.omfgdevelop.testtask.TestRequest;
import com.omfgdevelop.testtask.contract.AuthorizationFragmentContract;
import com.omfgdevelop.testtask.interfaces.AuthInterface;
import com.omfgdevelop.testtask.interfaces.SharedReaderInterface;
import com.omfgdevelop.testtask.model.Constants;
import com.omfgdevelop.testtask.model.DataLoader;

public class AuthorizationFragmentPresenter implements AuthorizationFragmentContract.Presenter, AuthInterface {
    AuthorizationFragmentContract.View view;
    AuthorizationFragmentContract.Model model;


    public AuthorizationFragmentPresenter(AuthorizationFragmentContract.View view) {
        this.view = view;


    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onButtonClicked(String login, String password) {
        SharedReaderInterface sharedReaderInterface = new DataLoader();
        sharedReaderInterface.WriteString(Constants.USERNAME,login);
        sharedReaderInterface.WriteString(Constants.PASSWORD,password);
        TestRequest request = new TestRequest(this);
        request.getCredentials();
        request.getBuilding();
    }

    @Override
    public void callback(String responsecode) {

        if(responsecode.equalsIgnoreCase("200")){
            view.attachBuildingFragment();
        }else if(responsecode.equalsIgnoreCase("401")){
            view.showToast("Wrong username or password ");
        }else {
            view.showToast("Error  "+ responsecode);
        }
    }
}