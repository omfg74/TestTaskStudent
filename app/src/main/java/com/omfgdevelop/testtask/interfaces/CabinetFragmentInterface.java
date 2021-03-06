package com.omfgdevelop.testtask.interfaces;

import com.omfgdevelop.testtask.model.CabType;
import com.omfgdevelop.testtask.model.Cabinet;

import java.util.List;

public interface CabinetFragmentInterface {
    void callback(List<Cabinet> cabinets);
    void callbackCabType(List<CabType>cabTypes);
}
