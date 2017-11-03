package com.bignerdranch.android.myweatherapp;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Tom on 11/2/17.
 */

public class CityWeatherAdapter extends RecyclerView.Adapter<CityWeatherHolder> {
    private List<Weather> mWeathers;
    private Fragment mFragment;

    public CityWeatherAdapter(Fragment f, List<Weather> weathers) {
        mFragment = f;
        mWeathers = weathers;
    }

    @Override
    public CityWeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mFragment.getActivity());
        View view = layoutInflater.inflate(R.layout.city_list_view_item, parent, false);
        return new CityWeatherHolder(mFragment, view);
    }

    @Override
    public void onBindViewHolder(CityWeatherHolder holder, int position) {
        Weather weather = mWeathers.get(position);
        holder.bindWeather(weather);
    }

    @Override
    public int getItemCount() {
        return mWeathers.size();
    }
}
