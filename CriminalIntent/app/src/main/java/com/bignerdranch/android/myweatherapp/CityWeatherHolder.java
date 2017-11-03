package com.bignerdranch.android.myweatherapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Tom on 11/2/17.
 */

public class CityWeatherHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {
    private TextView mCityNameTextView;
    private TextView mTempTextView;
    private TextView mTimeTextView;
    private Fragment mFragment;

    private Weather mWeather;

    public CityWeatherHolder(Fragment f, View itemView) {
        super(itemView);
        mFragment = f;
        itemView.setOnClickListener(this);

        mCityNameTextView = (TextView) itemView.findViewById(R.id.list_item_city_name);
        mTempTextView = (TextView) itemView.findViewById(R.id.list_item_temp);
        mTimeTextView = (TextView) itemView.findViewById(R.id.list_item_time);
    }

    public void bindWeather(Weather weather) {
        mWeather = weather;
        mCityNameTextView.setText(mWeather.getCity());
        mTempTextView.setText(String.valueOf(mWeather.getTemp()));
        mTimeTextView.setText(String.valueOf(mWeather.getTime()));
    }

    @Override
    public void onClick(View v) {
        Intent intent = CityPagerActivity.newIntent(mFragment.getActivity(), mWeather.getId());
        mFragment.startActivity(intent);
    }
}
