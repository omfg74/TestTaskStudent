package com.omfgdevelop.testtask.presenter;

import com.omfgdevelop.testtask.contract.MainActivityContract;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;
    MainActivityContract.Model model;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        view.attachAuthorizationFragment();
    }
}
