package com.example.helloapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {
    @GET("forecast")
    Call<WeatherData> getWeatherData(
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("hourly") String hourly
    );
}

