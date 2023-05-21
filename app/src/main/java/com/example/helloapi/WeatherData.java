package com.example.helloapi;

import com.google.gson.annotations.SerializedName;

public class WeatherData {
    @SerializedName("temperature_2m")
    private Temperature temperature;

    @SerializedName("wind_speed_10m")
    private WindSpeed windSpeed;

    // getter, setter, dan metode lainnya

    public class Temperature {
        @SerializedName("unit")
        private String unit;

        @SerializedName("values")
        private float[] values;

        // getter, setter, dan metode lainnya
    }

    public class WindSpeed {
        @SerializedName("unit")
        private String unit;

        @SerializedName("values")
        private float[] values;

        // getter, setter, dan metode lainnya
    }
}

