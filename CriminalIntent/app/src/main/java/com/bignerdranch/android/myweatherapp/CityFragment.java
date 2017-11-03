package com.bignerdranch.android.myweatherapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class CityFragment extends Fragment {

    private static final String WEATHER_ID = "weather_id";

    private Weather mWeather;
    private EditText mInput;
    private TextView mCity;
    private TextView mDate;
    private TextView mWeatherDescript;
    private TextView mTemp;

    public static CityFragment newInstance(UUID weatherId) {
        Bundle args = new Bundle();
        args.putSerializable(WEATHER_ID, weatherId);

        CityFragment fragment = new CityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID weatherId = (UUID) getArguments().getSerializable(WEATHER_ID);
        mWeather = WeatherLab.get(getActivity()).getWeather(weatherId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_city, container, false);

        mInput = (EditText) v.findViewById(R.id.input);
        mInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCity.setText(charSequence.toString());
                mWeather.setCity(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mCity = (TextView) v.findViewById(R.id.city_name);
        mCity.setText(mWeather.getCity());
        mDate = (TextView) v.findViewById(R.id.local_date);
        mDate.setText(String.valueOf(mWeather.getDate()));
        mWeatherDescript = (TextView) v.findViewById(R.id.weather_description);
        mWeatherDescript.setText(mWeather.getDescript());
        mTemp = (TextView) v.findViewById(R.id.city_temp);
        mTemp.setText(String.valueOf(mWeather.getTemp()));

        return v;
    }
}
