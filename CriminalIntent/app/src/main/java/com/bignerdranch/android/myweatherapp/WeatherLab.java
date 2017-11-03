package com.bignerdranch.android.myweatherapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WeatherLab {
    private static WeatherLab sWeatherLab;

    private ArrayList<Weather> mWeathers;

    public static WeatherLab get(Context context) {
        if (sWeatherLab == null) {
            sWeatherLab = new WeatherLab(context);
        }
        return sWeatherLab;
    }

    private WeatherLab(Context context) {
        mWeathers = new ArrayList<>();
    }

    public void addWeather(Weather w) {
        mWeathers.add(w);
    }

    public List<Weather> getWeathers() {
        return mWeathers;
    }

    public Weather getWeather(UUID id) {
        for (Weather weather : mWeathers) {
            if (weather.getId().equals(id)) {
                return weather;
            }
        }
        return null;
    }
}
