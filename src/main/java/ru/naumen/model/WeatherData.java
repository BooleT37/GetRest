package ru.naumen.model;

import java.io.Serializable;

/**
 * Created by dkirpichenkov on 31.10.16.
 */
public class WeatherData implements Serializable
{
    private int id;
    private String date;
    private int temperature;

    public WeatherData() {}

    public WeatherData(int id, String date, int temperature)
    {
        this.id = id;
        this.date = date;
        this.temperature = temperature;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return String.format("[id: %s, date: %s, temperature: %s]", id, date, temperature);
    }
}
