package com.example.api_weather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyForecast {
    List<Daily> daily;

    public DailyForecast() {
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }
}
