package ru.naumen.model;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ykalemi on 06.11.2016.
 */
@Named
public class HashMapStorage implements Storage {

    @PostConstruct
    public void addDataIfEmpty() {
        if (storage.isEmpty()) {
            storage.put(1, new WeatherData(1, "2011.05.15", 15));
            storage.put(2, new WeatherData(2, "2013.05.15", 3));
            storage.put(3, new WeatherData(3, "2014.05.15", 22));
        }
    }

    private Map<Integer, WeatherData> storage = new HashMap<>();

    public List<WeatherData> getAllData() {
        return new ArrayList<>(storage.values());
    }

    public WeatherData get(int id) {
        return storage.get(id);
    }

    public void add(WeatherData data) {
        storage.put(data.getId(), data);
    }

    public void remove(int id) {
        storage.remove(id);
    }
}
