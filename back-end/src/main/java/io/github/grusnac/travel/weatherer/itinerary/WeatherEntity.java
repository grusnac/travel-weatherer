package io.github.grusnac.travel.weatherer.itinerary;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WEATHER")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String main;
    private Double temperature;
    private Double pressure;
    private Double humidity;
    private String clouds;
    private LocalDate day;

    protected WeatherEntity() {}

    public WeatherEntity(String main, Double temperature, Double pressure, Double humidity, String clouds,
                         LocalDate day) {
        this.main = main;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.clouds = clouds;
        this.day = day;
    }

    public long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
