package com.bignerdranch.android.myweatherapp;

import android.support.v4.app.Fragment;

public class CityListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CityListFragment();
    }
}
