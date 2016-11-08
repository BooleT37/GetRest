package ru.naumen.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naumen.model.Storage;
import ru.naumen.model.WeatherData;
import ru.naumen.validators.WeatherDataValidator;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by dkirpichenkov on 31.10.16.
 */
@RestController
@Named
public class WeatherController {

    @Inject @Named("fileStorage")
    private Storage storage;

    @Inject @Named("weatherDataYearValidator")
    private WeatherDataValidator validator;

    @RequestMapping(value = "/weatherdata", method = RequestMethod.GET)
    public List<WeatherData> getWeather() {
        return storage.getAllData();
    }

    @RequestMapping(value = "/weatherdata/{id}", method = RequestMethod.GET)
    public WeatherData get(@PathVariable("id") int id) {
        return storage.get(id);
    }

    @RequestMapping(value = "/weatherdata", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody WeatherData data) {
        if (validator.validateWeatherData(data)) {
            storage.add(data);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/weatherdata/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (storage.get(id) != null) {
            storage.remove(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
