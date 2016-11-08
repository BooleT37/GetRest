package ru.naumen.validators;

import ru.naumen.model.WeatherData;

import javax.inject.Named;

@Named
public class WeatherDataYearValidator implements WeatherDataValidator {
    @Override
    public boolean validateWeatherData(WeatherData data) {
        int year = Integer.parseInt(data.getDate().split("\\.")[0]);
        return year <= 2017;
    }
}
