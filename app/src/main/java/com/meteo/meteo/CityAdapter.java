package com.meteo.meteo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by mangubu on 15/03/16.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private final ArrayList<City> cities;
    private OnclickListener listener;

    public CityAdapter(ArrayList<City> cities , OnclickListener listener ) {
        this.cities = cities;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View content = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_layout_content, parent,
                false);

        return new ViewHolder(content);
    }

    public void removeCity(int position){
        this.notifyItemRemoved(position);
        cities.remove(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.city.setText(cities.get(position).city);
        holder.country.setText(cities.get(position).country);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public final TextView city;
        public final TextView country;

        public ViewHolder(View itemView) {
            super(itemView);
            city = (TextView) itemView.findViewById(R.id.city);
            country = (TextView) itemView.findViewById(R.id.country);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener!= null){
                int position = getAdapterPosition();
                listener.onClick(position, cities.get(position));
            }
        }

    }
    public interface OnclickListener{
        void onClick(int position, City city);
    }

}
