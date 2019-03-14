package com.omfgdevelop.testtask.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.omfgdevelop.testtask.R;
import com.omfgdevelop.testtask.interfaces.BuildingInterface;
import com.omfgdevelop.testtask.model.Building;
import com.omfgdevelop.testtask.network.BuildingRequest;
import com.omfgdevelop.testtask.view.adapters.BuildingrecyclerViewAdapter;

import java.util.List;

public class BuldingFragment extends Fragment implements BuildingInterface {
RecyclerView recyclerView;
BuildingrecyclerViewAdapter adapter;
    List<Building> buildings;
    View view;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.building_fragment,container,false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Корпуса");
        BuildingRequest buildingRequest = new BuildingRequest(this);
        buildingRequest.getCredentials();
        buildingRequest.getBuildings();

    }

    @Override
    public void callback(List<Building> buildings) {
        this.buildings = buildings;
        recyclerView = view.findViewById(R.id.buildingRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new BuildingrecyclerViewAdapter(buildings,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void changeFragment(Building building) {
        Bundle bundle = new Bundle();
        bundle.putString("name",building.getName());
        bundle.putString("id",building.getId());
        CabinetFragment cabinetFragment = new CabinetFragment();
        cabinetFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_place, cabinetFragment)
                .addToBackStack(null)
                .commit();
    }
}
