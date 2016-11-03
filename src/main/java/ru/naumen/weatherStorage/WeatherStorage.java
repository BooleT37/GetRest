package ru.naumen.weatherStorage;

import ru.naumen.model.WeatherData;

import java.util.HashMap;
import java.util.Map;

public class WeatherStorage {
    private static WeatherStorage instance;
    private Map<Integer, WeatherData> data;
    private WeatherStorage() {
        data = new HashMap<>();
        data.put(0, new WeatherData("30-10-2016", -1));
        data.put(1, new WeatherData("31-10-2016", -3));
    }
    public static WeatherStorage getInstance() {
        if (instance == null)
            instance = new WeatherStorage();
        return instance;
    }

    public Map<Integer, WeatherData> getAll() {
        return data;
    }

    public WeatherData get(int id) throws WrongIdException {
        WeatherData item = data.get(id);
        if (item != null)
            return item;
        throw new WrongIdException(id);
    }

    public void add(Integer id, WeatherData item) {
        data.put(id, item);
    }

    public void delete(int id) throws WrongIdException {
        WeatherData result = data.remove(id);
        if (result == null)
            throw new WrongIdException(id);
    }

}

