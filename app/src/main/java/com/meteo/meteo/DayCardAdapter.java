package com.meteo.meteo;

import android.support.v7.widget.RecyclerView;
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
 * Created by mangubu on 15/03/16.
 */
public class DayCardAdapter extends RecyclerView.Adapter<DayCardAdapter.ViewHolder> {

    private ArrayList<String> dates;
    private OnclickListener listener;

    public DayCardAdapter(ArrayList<String> dates , OnclickListener listener ) {
        this.dates = dates;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View content = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_card_layout_content, parent,
                false);

        return new ViewHolder(content);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dateView.setText(dates.get(position));
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public final TextView dateView;

        public ViewHolder(View itemView) {
            super(itemView);
            dateView = (TextView) itemView.findViewById(R.id.date);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener!= null){
                int position = getAdapterPosition();
                listener.onClick(position, dates);
            }
        }

    }
    public interface OnclickListener{
        void onClick(int position, ArrayList<String> dates);
    }

}
