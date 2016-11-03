package ru.naumen.controllers;

import java.util.List;

import main.java.ru.naumen.weatherStorage.WeatherStorage;
import main.java.ru.naumen.weatherStorage.WrongIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.naumen.model.WeatherData;
import ru.naumen.model.Throwable;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by dkirpichenkov on 31.10.16.
 *
 * Простой пример REST контрлллера, который будет обрабатывать запросы
 *
 * <b>Важно</b>
 * 
 * @RestController автоматическое преобразование данных из/в JSON. Применение - класс
 * @RequestMapping - указание URL и HTTP метода для обработки. Применение метод/класс
 * @PathVariable - получение данных из url. Применение аргумент метода
 * @RequestBody - получение объекта из тела запроса
 */
@RestController
class WeatherController
{
    private WeatherStorage storage = WeatherStorage.getInstance();

    @RequestMapping(value = "/weatherdata", method = RequestMethod.GET)
    public List<WeatherData> getWeather()
    {
        return storage.getAll();
    }

    @RequestMapping(value = "/weatherdata/{id}", method = RequestMethod.GET)
    /*public Throwable<WeatherData> getOneWeather(@PathVariable("id") int id)
    {
        try {
            WeatherData data = storage.get(id);
            return new Throwable<>(false, data);
        } catch (WrongIdException e) {
            return new Throwable<WeatherData>(false, e.getMessage());
        }
    }*/

    public WeatherData getOneWeather(@PathVariable("id") int id, HttpServletResponse response)
    {
        try {
            return storage.get(id);
        } catch (WrongIdException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }
}
