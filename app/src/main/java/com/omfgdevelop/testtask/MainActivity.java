package com.omfgdevelop.testtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.omfgdevelop.testtask.contract.MainActivityContract;
import com.omfgdevelop.testtask.presenter.MainActivityPresenter;
import com.omfgdevelop.testtask.view.fragments.AuthorizationFragment;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {


    MainActivityContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        presenter.onCreate();
    }

    @Override
    public void attachAuthorizationFragment() {
        AuthorizationFragment authorizationFragment = new AuthorizationFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_place,authorizationFragment)
                .commit();
    }
}
