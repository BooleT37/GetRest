package ru.naumen.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naumen.model.HashMapStorage;
import ru.naumen.model.WeatherData;

import java.util.List;

/**
 * Created by dkirpichenkov on 31.10.16.
 */
@RestController
public class WeatherController {

    private HashMapStorage storage = HashMapStorage.getInstance();

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
        storage.add(data);
        return ResponseEntity.ok().build();
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
