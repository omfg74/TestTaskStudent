package com.omfgdevelop.testtask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cabinet {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("building_id")
    @Expose
    public String buildingId;
    @SerializedName("num")
    @Expose
    public String num;
    @SerializedName("floor")
    @Expose
    public String floor;
    @SerializedName("category_id")
    @Expose
    public String cetegoryId;
    @SerializedName("count")
    @Expose
    public String count;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setCetegoryId(String cetegoryId) {
        this.cetegoryId = cetegoryId;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public String getNum() {
        return num;
    }

    public String getFloor() {
        return floor;
    }

    public String getCetegoryId() {
        return cetegoryId;
    }

    public String getCount() {
        return count;
    }
}
