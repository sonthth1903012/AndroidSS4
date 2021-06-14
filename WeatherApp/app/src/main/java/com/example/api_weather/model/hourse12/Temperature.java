package com.example.api_weather.model.hourse12;

import com.google.gson.annotations.SerializedName;

public class Temperature {
    @SerializedName("Value")
    public double value;
    @SerializedName("Unit")
    public String unit;
    @SerializedName("UnitType")
    public int unitType;

    public Temperature() {
    }

    public Temperature(double value, String unit, int unitType) {
        this.value = value;
        this.unit = unit;
        this.unitType = unitType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }
}
