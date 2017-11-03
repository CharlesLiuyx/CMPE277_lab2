package com.bignerdranch.android.myweatherapp;

import android.text.format.Time;

import java.util.Date;
import java.util.UUID;

public class Weather {

    private UUID mId;
    private String mCity;
    private Date mDate;
    private Time mTime;
    private String mDescript;
    private Double mTemp;

    public Weather() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }


    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public Time getTime() {
        return mTime;
    }

    public void setTime(Time time) {
        mTime = time;
    }

    public String getDescript() {
        return mDescript;
    }

    public void setDescript(String descript) {
        mDescript = descript;
    }

    public Double getTemp() {
        return mTemp;
    }

    public void setTemp(Double temp) {
        mTemp = temp;
    }

    public UUID getId() {
        return mId;
    }

    public Date getDate() {
        return mDate;
    }
}
