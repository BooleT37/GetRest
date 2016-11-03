package ru.naumen.model;

public class WeatherData
{
    private String date;
    private int temperature;

    public WeatherData(String date, int temperature)
    {
        this.date = date;
        this.temperature = temperature;
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
}
