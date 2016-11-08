package ru.naumen.model;

import java.util.List;

public interface Storage {
    List<WeatherData> getAllData();

    WeatherData get(int id);

    void add(WeatherData data);

    void remove(int id);
}
