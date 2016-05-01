package com.meteo.meteo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by mangubu on 15/03/16.
 */
public class CityActivity extends AppCompatActivity implements CityAdapter.OnclickListener {

    private CityAdapter cityAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.city_layout);
        String app_name = getResources().getString(R.string.app_name);


    }

    @Override
    public void onClick(final int position, City city) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}

