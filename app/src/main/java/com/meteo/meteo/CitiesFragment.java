package com.meteo.meteo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by mangubu on 17/03/16.
 */
public class CitiesFragment extends Fragment implements CityAdapter.OnclickListener{

    private CityAdapter cityAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ArrayList<City> cities = new ArrayList<City>();
        cities.add(new City("Paris", "Ile de France"));
        cities.add(new City("Marseille", "Bouche du rhône"));

        cityAdapter = new CityAdapter(cities, (CityAdapter.OnclickListener) this);
        final RecyclerView list = (RecyclerView) view.findViewById(R.id.Recycler);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(cityAdapter);
    }

    @Override
    public void onClick(final int position, City city) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Voulez-vous supprimer la ville ?").setTitle("Suppression ville");

        builder.setPositiveButton("ANNULER", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("SUPPRIMER", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cityAdapter.removeCity(position);
                dialog.dismiss();
            }
        });

        builder.show();
    }
}
