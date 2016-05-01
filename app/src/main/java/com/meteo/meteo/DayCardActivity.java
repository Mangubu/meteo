package com.meteo.meteo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by mangubu on 15/03/16.
 */
public class DayCardActivity extends AppCompatActivity implements DayCardAdapter.OnclickListener {

    private DayCardAdapter dayCardAdapter;
    private ArrayList<String> dates = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.day_card_layout);
        String app_name = getResources().getString(R.string.app_name);

        Calendar today = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE", Locale.getDefault());

        for (int i = 0; i < 4 ; i++) {


            today.add(Calendar.DAY_OF_MONTH, 1);


            String date = sdf.format(today.getTimeInMillis());

            dates.add(date);
        }



        dayCardAdapter = new DayCardAdapter(dates, this);


        final RecyclerView list = (RecyclerView) findViewById(R.id.DayCard);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(dayCardAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(int position, ArrayList<String> dates) {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Voulez-vous supprimer la ville ?").setTitle("Suppression ville");

        builder.setPositiveButton("ANNULER", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("SUPPRIMER", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //.removeCity(position);
                dialog.dismiss();
            }
        });

        builder.show();*/
    }
}

