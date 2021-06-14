package com.example.api_weather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {
    @SerializedName("Date")
    public String date;
    @SerializedName("EpochDate")
    public int epochDate;
    @SerializedName("Temperature")
    public Temperature temperature;
    @SerializedName("Day")
    public Day day;
    @SerializedName("Night")
    public Night night;
    @SerializedName("Sources")
    public List<String> sources;
    @SerializedName("MobileLink")
    public String mobileLink;
    @SerializedName("Link")
    public String link;

    public Daily() {
    }

    public Daily(String date, String link) {
        this.date = date;
        this.link = link;
    }
    public Daily(String date, int epochDate, Temperature temperature, Day day, Night night, List<String> sources, String mobileLink, String link) {
        this.date = date;
        this.epochDate = epochDate;
        this.temperature = temperature;
        this.day = day;
        this.night = night;
        this.sources = sources;
        this.mobileLink = mobileLink;
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEpochDate() {
        return epochDate;
    }

    public void setEpochDate(int epochDate) {
        this.epochDate = epochDate;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Night getNight() {
        return night;
    }

    public void setNight(Night night) {
        this.night = night;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
