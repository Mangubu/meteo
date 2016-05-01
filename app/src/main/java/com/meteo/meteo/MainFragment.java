package com.meteo.meteo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by mangubu on 17/03/16.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Calendar today = Calendar.getInstance();
        LinearLayout weektemp = (LinearLayout) view.findViewById(R.id.weektemp);


        for (int i = 0; i < weektemp.getChildCount() ; i++) {

            today.add(Calendar.DAY_OF_MONTH, 1);
            SimpleDateFormat sdf = new SimpleDateFormat("EEE", Locale.getDefault());
            String date = sdf.format(today.getTimeInMillis());

            LinearLayout dayView = (LinearLayout) weektemp.getChildAt(i);
            // TextView weekDay = (TextView) dayView.findViewById(R.id.weektemp);

            TextView weekDay = (TextView) dayView.findViewById(R.id.weekDay);

            weekDay.setText(date.substring(0, 1).toUpperCase() + date.substring(1, date.length() -1 ).toLowerCase());
        }
        weektemp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent daydetail = new Intent(getContext(), DayCardActivity.class);
        startActivity(daydetail);
    }
}
