package com.meteo.meteo;


/**
 * Created by mangubu on 26/04/16.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void servieFailure(Exception exception);
}
