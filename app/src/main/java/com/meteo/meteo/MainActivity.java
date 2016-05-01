package com.meteo.meteo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity{
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String app_name = getResources().getString(R.string.app_name);

        Toast.makeText(this, app_name, Toast.LENGTH_LONG).show();
        Log.i("Nom de mon app", app_name);

        if (!getResources().getBoolean(R.bool.IsTablet)) {
            mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
            mViewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));

            TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
            tabLayout.setupWithViewPager(mViewPager);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!getResources().getBoolean(R.bool.IsTablet)) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        } else {
            return false;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent citiesIntent = new Intent(this, CityActivity.class);
        startActivity(citiesIntent);
        return true;
    }

    // CODE FOR TOOLBAR
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }*/
}
