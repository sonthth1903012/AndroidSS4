package com.example.api_weather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {
    @SerializedName("Headline")
    private Headline headline;
    @SerializedName("DailyForecasts")
    private List<Daily> daily;

    public Weather() {
    }

    public Weather(Headline headline, List<Daily> daily) {
        this.headline = headline;
        this.daily = daily;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }


}
