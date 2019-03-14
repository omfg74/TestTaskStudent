package com.omfgdevelop.testtask.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.omfgdevelop.testtask.Logger;
import com.omfgdevelop.testtask.R;
import com.omfgdevelop.testtask.TestTask;
import com.omfgdevelop.testtask.model.Cabinet;

import java.util.HashMap;
import java.util.List;

public class CabinetAdapter extends  RecyclerView.Adapter<CabinetAdapter.ViewHolder> {
    private View view;
    private HashMap<Integer,String> map;
    private List<Cabinet> cabinetsByBuilding;

    public CabinetAdapter(List<Cabinet> cabinetsByBuilding) {
        this.cabinetsByBuilding = cabinetsByBuilding;
        Logger.toLog(String.valueOf("ada "+cabinetsByBuilding.size()));
    }

    @NonNull
    @Override
    public CabinetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(TestTask.getContext()).inflate(R.layout.cabinet_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CabinetAdapter.ViewHolder viewHolder, int i) {
        viewHolder.cabinetName.setText(cabinetsByBuilding.get(i).name);
//        viewHolder.type.setText(cabinetsByBuilding.get(i).);
        viewHolder.count.setText("Count "+cabinetsByBuilding.get(i).getCount());
        viewHolder.floorTextView.setText("Этаж "+cabinetsByBuilding.get(i).floor);
    }

    @Override
    public int getItemCount() {
        return cabinetsByBuilding.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView cabinetName, floorTextView, count, type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cabinetName = itemView.findViewById(R.id.CabinetName);
            floorTextView = itemView.findViewById(R.id.floorTextView);
            count = itemView.findViewById(R.id.count);
            type = itemView.findViewById(R.id.type);
        }

    }
    private void getCabType(){

    }
}
