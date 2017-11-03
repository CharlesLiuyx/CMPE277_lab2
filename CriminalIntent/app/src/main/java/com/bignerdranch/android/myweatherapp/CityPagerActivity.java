package com.bignerdranch.android.myweatherapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class CityPagerActivity extends AppCompatActivity {

    private static final String EXTRA_CITY_ID =
            "com.bignerdranch.android.myweatherapp.city_id";

    private ViewPager mViewPager;
    private List<Weather> mWeathers;

    public static Intent newIntent(Context packageContext, UUID cityId) {
        Intent intent = new Intent(packageContext, CityPagerActivity.class);
        intent.putExtra(EXTRA_CITY_ID, cityId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_pager);

        UUID cityId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CITY_ID);

        mViewPager = (ViewPager) findViewById(R.id.city_pager_view);

        mWeathers = WeatherLab.get(this).getWeathers();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Weather weather = mWeathers.get(position);
                return CityFragment.newInstance(weather.getId());
            }

            @Override
            public int getCount() {
                return mWeathers.size();
            }
        });

        for (int i = 0; i < mWeathers.size(); i++) {
            if (mWeathers.get(i).getId().equals(cityId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
