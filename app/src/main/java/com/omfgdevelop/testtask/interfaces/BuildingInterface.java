package com.omfgdevelop.testtask.interfaces;

import com.omfgdevelop.testtask.model.Building;

import java.util.List;

public interface BuildingInterface {
    void callback(List<Building> buildings);
    void changeFragment(Building building);
}
