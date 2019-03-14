package com.omfgdevelop.testtask.view.adapters;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.omfgdevelop.testtask.Logger;
import com.omfgdevelop.testtask.R;
import com.omfgdevelop.testtask.TestTask;
import com.omfgdevelop.testtask.interfaces.CabTypeInterface;
import com.omfgdevelop.testtask.model.CabType;
import com.omfgdevelop.testtask.model.Cabinet;
import com.omfgdevelop.testtask.network.CabTypeRequest;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class CabinetAdapter extends  RecyclerView.Adapter<CabinetAdapter.ViewHolder> {
    private View view;
    private HashMap<Integer,String> map;
    private List<Cabinet> cabinetsByBuilding;
    private List<CabType>cabTypes;

    public CabinetAdapter(List<Cabinet> cabinetsByBuilding, List<CabType>cabTypes) {
        this.cabinetsByBuilding = cabinetsByBuilding;
        this.cabTypes = cabTypes;

        Logger.toLog(String.valueOf("ada "+cabinetsByBuilding.size()));
    }

    @NonNull
    @Override
    public CabinetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(TestTask.getContext()).inflate(R.layout.cabinet_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        viewHolder.type.setText(cabinetsByBuilding.get(i).);
        viewHolder.count.setText("Count "+cabinetsByBuilding.get(i).getCount());
        viewHolder.floorTextView.setText("Этаж "+cabinetsByBuilding.get(i).floor);
        for (int j = 0; j <cabTypes.size() ; j++) {
            if(cabinetsByBuilding.get(i).getCetegoryId().equalsIgnoreCase(cabTypes.get(j).getId())){
                viewHolder.type.setText(cabTypes.get(j).getName());
                if(cabTypes.get(j).getId().equalsIgnoreCase("00-000001")){
                viewHolder.floatingActionButton.setBackgroundColor(TestTask.getContext().getResources().getColor(R.color.colorMarine));
                }else if(cabTypes.get(j).getId().equalsIgnoreCase("00-000007")){
                    viewHolder.floatingActionButton.setBackgroundColor(TestTask.getContext().getResources().getColor(R.color.colorBlue));
                }else if(cabTypes.get(j).getId().equalsIgnoreCase("00-000002")){
                    viewHolder.floatingActionButton.setBackgroundColor(TestTask.getContext().getResources().getColor(R.color.colorDarkGray));
                }else if(cabTypes.get(j).getId().equalsIgnoreCase("00-000003")){
                    viewHolder.floatingActionButton.setBackgroundColor(TestTask.getContext().getResources().getColor(R.color.colorPink));
                }else if(cabTypes.get(j).getId().equalsIgnoreCase("00-000004")){
                    viewHolder.floatingActionButton.setBackgroundColor(TestTask.getContext().getResources().getColor(R.color.colorAccent));
                }else if(cabTypes.get(j).getId().equalsIgnoreCase("00-000005")){
                    viewHolder.floatingActionButton.setBackgroundColor(TestTask.getContext().getResources().getColor(R.color.colorPrimary));
                }else if(cabTypes.get(j).getId().equalsIgnoreCase("00-000006")){
                    viewHolder.floatingActionButton.setBackgroundColor(TestTask.getContext().getResources().getColor(R.color.colorRed));
                }else if(cabTypes.get(j).getId().equalsIgnoreCase("00-000001")){
                    viewHolder.floatingActionButton.setBackgroundColor(TestTask.getContext().getResources().getColor(R.color.colorYellow));
                }else if (cabTypes.get(j).getId().equalsIgnoreCase("УВ-000001")){
                    viewHolder.floatingActionButton.setBackgroundColor(TestTask.getContext().getResources().getColor(R.color.colorPrimaryDark));
                }

            }
        }
    }

    @Override
    public int getItemCount() {
        return cabinetsByBuilding.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView cabinetName;
        TextView floorTextView, count, type;
        CoordinatorLayout floatingActionButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            floatingActionButton = itemView.findViewById(R.id.fab);
            cabinetName = itemView.findViewById(R.id.CabinetName);
            floorTextView = itemView.findViewById(R.id.floorTextView);
            count = itemView.findViewById(R.id.count);
            type = itemView.findViewById(R.id.type);
        }

    }
//    private void getCabType(){
//        CabTypeRequest cabTypeRequest = new CabTypeRequest(this);
//        cabTypeRequest.getCredentials();
//        cabTypeRequest.getcabType();
//    }
}
