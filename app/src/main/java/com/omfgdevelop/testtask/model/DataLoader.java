package com.omfgdevelop.testtask.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.omfgdevelop.testtask.TestTask;
import com.omfgdevelop.testtask.interfaces.SharedReaderInterface;

public class DataLoader implements SharedReaderInterface {
    @Override
    public String readString(String key) {
        SharedPreferences sharedPreferences = TestTask.getContext().getSharedPreferences(Constants.CREDENTIALS, Context.MODE_PRIVATE);
       return sharedPreferences.getString(key,null);

    }

    @Override
    public void WriteString(String key, String value) {
        SharedPreferences sharedPreferences = TestTask.getContext().getSharedPreferences(Constants.CREDENTIALS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }
}
