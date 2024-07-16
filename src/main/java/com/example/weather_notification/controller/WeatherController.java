package com.example.weather_notification.controller;

import com.example.weather_notification.dto.Weather;
import com.example.weather_notification.dto.WeatherTestDto;
import com.example.weather_notification.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<WeatherTestDto> findAll() {
        return weatherService.findAll();
    }

    @GetMapping(value = "/current", produces = "application/json")
    public ResponseEntity<Weather> getCurrentWeather() {
        try {
            Weather weather = weatherService.fetchCurrentWeather();
            return ResponseEntity.ok(weather);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
