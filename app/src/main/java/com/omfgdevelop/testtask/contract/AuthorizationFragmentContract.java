package com.omfgdevelop.testtask.contract;

public interface AuthorizationFragmentContract {
    public interface View{
        void attachBuildingFragment();
        void showToast(String s);
    }
    public interface Presenter{
        void onCreate();
        void onButtonClicked(String login, String password);

    }
    public interface Model {

    }
}
