package com.meteo.meteo;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mangubu on 17/03/16.
 */
public class MainAdapter extends FragmentPagerAdapter {
    public MainAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public Fragment getItem(int i) {
        return new MainFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "titre";

    }
}