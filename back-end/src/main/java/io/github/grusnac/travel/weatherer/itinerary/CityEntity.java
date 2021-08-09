package io.github.grusnac.travel.weatherer.itinerary;

import javax.persistence.*;

@Entity
@Table(name = "CITIES")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String countryCode;
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private WeatherEntity weather;

    protected CityEntity() {
    }

    public CityEntity(String name, String countryCode, WeatherEntity weather) {
        this.name = name;
        this.countryCode = countryCode;
        this.weather = weather;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public WeatherEntity getWeather() {
        return weather;
    }

    public void setWeather(WeatherEntity weather) {
        this.weather = weather;
    }
}
