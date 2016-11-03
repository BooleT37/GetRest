package ru.naumen.controllers;

import java.util.Map;

import ru.naumen.weatherStorage.WeatherStorage;
import ru.naumen.weatherStorage.WrongIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.naumen.model.WeatherData;

import javax.servlet.http.HttpServletRequest;
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
    public Map<Integer, WeatherData> getWeather()
    {
        return storage.getAll();
    }

    @RequestMapping(value = "/weatherdata/{id}", method = RequestMethod.GET)
    public WeatherData getOneWeather(@PathVariable("id") int id, HttpServletResponse response)
    {
        try {
            return storage.get(id);
        } catch (WrongIdException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @RequestMapping(value = "/weatherdata/addWeatherData", method = RequestMethod.PUT)
    public void addWeatherData(HttpServletRequest request)
    {
        Map<String, String[]> params = request.getParameterMap();
        Integer id = Integer.parseInt(params.get("id")[0]);
        String date = params.get("date")[0];
        Integer temperature = Integer.parseInt(params.get("temperature")[0]);
        storage.add(id, new WeatherData(date, temperature));
    }

    @RequestMapping(value = "/weatherdata/deleteWeatherData", method = RequestMethod.DELETE)
    public void deleteWeatherData(HttpServletRequest request, HttpServletResponse response)
    {
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            storage.delete(id);
        } catch (WrongIdException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
    }
}
