package com.example.api_weather.model.hourse12;

import com.google.gson.annotations.SerializedName;

public class HourseWeather {
    @SerializedName("DateTime")
    public String dateTime;
    @SerializedName("EpochDateTime")
    public int epochDateTime;
    @SerializedName("WeatherIcon")
    public int weatherIcon;
    @SerializedName("IconPhrase")
    public String iconPhrase;
    @SerializedName("HasPrecipitation")
    public boolean hasPrecipitation;
    @SerializedName("IsDaylight")
    public boolean isDaylight;
    @SerializedName("Temperature")
    public Temperature temperature;
    @SerializedName("PrecipitationProbability")
    public int precipitationProbability;
    @SerializedName("MobileLink")
    public String mobileLink;
    @SerializedName("Link")
    public String link;
    @SerializedName("PrecipitationType")
    public String precipitationType;
    @SerializedName("PrecipitationIntensity")
    public String precipitationIntensity;

    public HourseWeather() {
    }

    public HourseWeather(String dateTime, int epochDateTime, int weatherIcon, String iconPhrase, boolean hasPrecipitation, boolean isDaylight, Temperature temperature, int precipitationProbability, String mobileLink, String link, String precipitationType, String precipitationIntensity) {
        this.dateTime = dateTime;
        this.epochDateTime = epochDateTime;
        this.weatherIcon = weatherIcon;
        this.iconPhrase = iconPhrase;
        this.hasPrecipitation = hasPrecipitation;
        this.isDaylight = isDaylight;
        this.temperature = temperature;
        this.precipitationProbability = precipitationProbability;
        this.mobileLink = mobileLink;
        this.link = link;
        this.precipitationType = precipitationType;
        this.precipitationIntensity = precipitationIntensity;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getEpochDateTime() {
        return epochDateTime;
    }

    public void setEpochDateTime(int epochDateTime) {
        this.epochDateTime = epochDateTime;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public boolean isDaylight() {
        return isDaylight;
    }

    public void setDaylight(boolean daylight) {
        isDaylight = daylight;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public int getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
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

    public String getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public String getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    public void setPrecipitationIntensity(String precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }
}
