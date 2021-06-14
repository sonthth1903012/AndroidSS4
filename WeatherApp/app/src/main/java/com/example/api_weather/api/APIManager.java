package com.example.api_weather.api;

import com.example.api_weather.model.Headline;
import com.example.api_weather.model.Weather;
import com.example.api_weather.model.hourse12.HourseWeather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String SERVER_URL = "http://dataservice.accuweather.com/forecasts/v1/";

    @GET("daily/5day/353412?apikey=dJ0A6oFnbXuekbS0CbZeI9pxdy6CEFTq&language=vi-vn&metric=true")
    Call<Weather> get5Day();

    @GET("hourly/12hour/353412?apikey=dJ0A6oFnbXuekbS0CbZeI9pxdy6CEFTq&language=vi-vn&metric=true")
    Call<List<HourseWeather>> get12Hour();
}
