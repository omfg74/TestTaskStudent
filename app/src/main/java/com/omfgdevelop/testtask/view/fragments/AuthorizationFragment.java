package com.omfgdevelop.testtask.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.omfgdevelop.testtask.R;
import com.omfgdevelop.testtask.contract.AuthorizationFragmentContract;
import com.omfgdevelop.testtask.network.BuildingRequest;
import com.omfgdevelop.testtask.presenter.AuthorizationFragmentPresenter;

public class AuthorizationFragment extends Fragment implements AuthorizationFragmentContract.View {

    View view;
    AuthorizationFragmentContract.Presenter presenter;
    TextInputEditText loginEditText, passwordEditText;
    MaterialButton loginButton;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter =  new AuthorizationFragmentPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.authirization_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginEditText = view.findViewById(R.id.loginEditText);
        loginEditText.setText("json");//for fast testing only !!!
        passwordEditText = view.findViewById(R.id.passwordEdittext);
        passwordEditText.setText("KCKPV8zJDx8TX3SZ");//for fast testing only !!!
        loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClicked(loginEditText.getText().toString(),passwordEditText.getText().toString());
            }
        });
        passwordEditText.setImeActionLabel("OK", EditorInfo.IME_ACTION_DONE);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // обрабатываем нажатие кнопки DONE
                    presenter.onButtonClicked(loginEditText.getText().toString(),passwordEditText.getText().toString());
                }
                return true;
            }

        });
    }

    @Override
    public void attachBuildingFragment() {

        BuldingFragment buildingFragment  = new BuldingFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_place,buildingFragment)
                .commit();
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }
}
