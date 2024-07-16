package com.example.weather_notification.service;

import com.example.weather_notification.dto.Weather;
import com.example.weather_notification.dto.WeatherTestDto;
import com.example.weather_notification.mapper.WeatherMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class WeatherService {
    private final WeatherMapper weatherMapper;
    @Value("${openweathermap.api.key}")
    private String apiKey;

    public WeatherService(WeatherMapper weatherMapper) {
        this.weatherMapper = weatherMapper;
    }

    public List<WeatherTestDto> findAll() {
        return weatherMapper.findAll();
    }

    public Weather fetchCurrentWeather() throws JSONException {
        String url = "https://api.openweathermap.org/data/2.5/weather?id=1835848&units=metric&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        JSONObject jsonObject = new JSONObject(response);

        Weather weather = new Weather();
        String cityName = jsonObject.getString("name");
        weather.setCity(cityName);
        weather.setDate(Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        weather.setTemperature(jsonObject.getJSONObject("main").getDouble("temp"));
        weather.setDescription(jsonObject.getJSONArray("weather").getJSONObject(0).getString("description"));
        double minTemp = jsonObject.getJSONObject("main").getDouble("temp_min");
        double maxTemp = jsonObject.getJSONObject("main").getDouble("temp_max");
        weather.setMinTemperature(minTemp);
        weather.setMaxTemperature(maxTemp);

        return weather;
    }
}