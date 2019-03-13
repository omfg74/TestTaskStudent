package com.omfgdevelop.testtask.abstraction;

import android.util.Base64;

import com.omfgdevelop.testtask.interfaces.SharedReaderInterface;
import com.omfgdevelop.testtask.model.Constants;
import com.omfgdevelop.testtask.model.DataLoader;

public class BaseRequest extends AbstractRequest {
  public String authHeader;
    @Override
    public void getCredentials() {
        SharedReaderInterface sharedReaderInterface = new DataLoader();
        String base =  sharedReaderInterface.readString(Constants.USERNAME)+":"+ sharedReaderInterface.readString(Constants.PASSWORD);
        this.authHeader = "Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
    }
}
