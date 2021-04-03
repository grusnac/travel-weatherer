package io.github.grusnac.travel.weatherer.itinerary;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CITIES")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String countryCode;
    @OneToMany(targetEntity = WeatherEntity.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true, mappedBy = "id")
    private List<WeatherEntity> weather;

    protected CityEntity() {}

    public CityEntity(String name, String countryCode, List<WeatherEntity> weather) {
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

    public List<WeatherEntity> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherEntity> weather) {
        this.weather = weather;
    }
}
