package com.example.weather_notification.mapper;

import com.example.weather_notification.dto.Weather;
import com.example.weather_notification.dto.WeatherTestDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeatherMapper {
    List<WeatherTestDto> findAll();

    @Insert("INSERT INTO weather (date, temperature, description) VALUES (#{date}, #{temperature}, #{description})")
    void insertWeather(Weather weather);
}
