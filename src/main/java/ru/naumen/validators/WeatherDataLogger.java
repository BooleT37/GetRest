package ru.naumen.validators;

import ru.naumen.model.WeatherData;

import javax.inject.Named;

@Named
public class WeatherDataLogger implements WeatherDataValidator {
    @Override
    public boolean validateWeatherData(WeatherData data) {
        System.out.println("Data validated: ".concat(data.toString()));
        return true;
    }
}
