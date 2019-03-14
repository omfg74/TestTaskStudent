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

import com.omfgdevelop.testtask.Logger;
import com.omfgdevelop.testtask.R;
import com.omfgdevelop.testtask.interfaces.CabinetFragmentInterface;
import com.omfgdevelop.testtask.model.Building;
import com.omfgdevelop.testtask.model.Cabinet;
import com.omfgdevelop.testtask.network.BuildingRequest;
import com.omfgdevelop.testtask.network.CabinetRequest;
import com.omfgdevelop.testtask.view.adapters.CabinetAdapter;

import java.util.ArrayList;
import java.util.List;

public class CabinetFragment extends Fragment implements CabinetFragmentInterface {
    View view;
    RecyclerView recyclerView;
    Building building;
    CabinetAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.building_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.buildingRecyclerView);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      unpackBundle();
        setTitle(building);
    }

    private void setTitle(Building building) {
        getActivity().setTitle(building.getName());
    }

    private Building unpackBundle() {
        Bundle bundle = this.getArguments();
        building = new Building();
        building.setId(bundle.getString("id"));
        building.setName(bundle.getString("name"));
        return building;
    }

    @Override
    public void onResume() {
        super.onResume();
        CabinetRequest cabinetRequest = new CabinetRequest(this);
        cabinetRequest.getCredentials();
        cabinetRequest.getCabinets();

    }

    @Override
    public void callback(List<Cabinet> cabinets) {
        Logger.toLog("cba "+String.valueOf(cabinets.size()));
      List<Cabinet>cabinetsByBuilding = new ArrayList<>();
        for (int i = 0; i < cabinets.size(); i++) {
            Logger.toLog("bid "+cabinets.get(i).getBuildingId());
            if(cabinets.get(i).getBuildingId().equalsIgnoreCase(building.getId())){
                cabinetsByBuilding.add(cabinets.get(i));
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter  = new CabinetAdapter(cabinetsByBuilding);
        recyclerView.setAdapter(adapter);

    }
}
