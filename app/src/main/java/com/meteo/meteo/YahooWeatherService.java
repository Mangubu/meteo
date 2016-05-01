package com.meteo.meteo;

import android.os.AsyncTask;
/**
 * Created by mangubu on 26/04/16.
 */
public class YahooWeatherService {
    private WeatherServiceCallback callback;
    private String location;

    public YahooWeatherService(WeatherServiceCallback callback){

        this.callback = callback;

    }

    public String getLocation(){

        return location;
    }

    public void refreshWeather(String location){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                return null;
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
            }
        }.execute(location);
    }
}
