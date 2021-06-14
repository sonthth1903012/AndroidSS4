package com.example.api_weather.model;

import com.google.gson.annotations.SerializedName;

public class Temperature {
    @SerializedName("Minimum")
    public Minimum minimum;
    @SerializedName("Maximum")
    public Maximum maximum;

    public Temperature() {
    }

    public Minimum getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    public Maximum getMaximum() {
        return maximum;
    }

    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }
}
