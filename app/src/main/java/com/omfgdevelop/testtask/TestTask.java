package com.omfgdevelop.testtask;

import android.app.Application;
import android.content.Context;

public class TestTask extends Application {
    private static Context context;


    public void onCreate() {
        super.onCreate();
        TestTask.context = getApplicationContext();
    }

    public static Context getContext() {
        return TestTask.context;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}