package com.omfgdevelop.testtask.view.adapters;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.omfgdevelop.testtask.Logger;
import com.omfgdevelop.testtask.R;
import com.omfgdevelop.testtask.TestTask;
import com.omfgdevelop.testtask.model.Building;
import com.omfgdevelop.testtask.view.fragments.BuldingFragment;

import java.util.HashMap;
import java.util.List;

public class BuildingrecyclerViewAdapter extends RecyclerView.Adapter<BuildingrecyclerViewAdapter.ViewHolder> {

    private View view;
   private HashMap<Integer,String> map;
    private List<Building>buildings;
    BuldingFragment buldingFragment;

    public BuildingrecyclerViewAdapter(List<Building>buildings, BuldingFragment buldingFragment) {
        this.buldingFragment = buldingFragment;
        this.buildings = buildings;
        map = new HashMap<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         view = LayoutInflater.from(TestTask.getContext()).inflate(R.layout.bulding_recycler_view_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.editText.setText(buildings.get(i).getName());
        map.put(i,buildings.get(i).getId());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(TestTask.getContext(), "click "+map.get(i).toString(), Toast.LENGTH_SHORT).show();
                buldingFragment.changeFragment(buildings.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {

        Logger.toLog(String.valueOf("size "+buildings.size()));
        return buildings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView editText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.building_name);
        }
    }
}
