package com.example.weather_notification.dto;

public class Weather {

    private String city;
    private String date;
    private double temperature;
    private double MinTemperature;
    private double MaxTemperature;
    private String description;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getMinTemperature() {
        return MinTemperature;
    }

    public void setMinTemperature(double MinTemperature) {
        this.MinTemperature = MinTemperature;
    }

    public double getMaxTemperature() {
        return MaxTemperature;
    }

    public void setMaxTemperature(double MaxTemperature) {
        this.MaxTemperature = MaxTemperature;
    }
}
