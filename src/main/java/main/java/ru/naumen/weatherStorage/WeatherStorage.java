package main.java.ru.naumen.weatherStorage;

import ru.naumen.model.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class WeatherStorage {
    private static WeatherStorage instance;
    private List<WeatherData> data; //todo rewrite using map
    private WeatherStorage() {
        data = new ArrayList<>();
        data.add(new WeatherData(0, "30-10-2016", -1));
        data.add(new WeatherData(1, "31-10-2016", -3));
    }
    public static WeatherStorage getInstance() {
        if (instance == null)
            instance = new WeatherStorage();
        return instance;
    }

    public List<WeatherData> getAll() {
        return data;
    }

    public WeatherData get(int id) throws WrongIdException {
        for (WeatherData item : data) {
            if (item.getId() == id)
                return item;
        }
        throw new WrongIdException(id);
    }

    public void add(WeatherData item) {
        data.add(item);
    }

    public void delete(int id) throws WrongIdException {
        for (WeatherData item : data) {
            if (item.getId() == id) {
                data.remove(item);
                return;
            }
        }
        throw new WrongIdException(id);
    }

}

