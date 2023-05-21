package com.example.helloapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView textLatitude;
    private TextView textLongitude;
    private TextView textTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textLatitude = findViewById(R.id.textLatitude);
        textLongitude = findViewById(R.id.textLongitude);
        textTemperature = findViewById(R.id.textTemperature);

        Intent intent = getIntent();
        String latitude = intent.getStringExtra("latitude");
        String longitude = intent.getStringExtra("longitude");
        String temperature = intent.getStringExtra("temperature");

        textLatitude.setText("Latitude: " + latitude);
        textLongitude.setText("Longitude: " + longitude);
        textTemperature.setText("Temperature: " + temperature);
    }
}

