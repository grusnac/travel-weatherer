package io.github.grusnac.travel.weatherer.itinerary;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Component
public class WeatherEntityConverter implements Converter<ItineraryAdditionRequest.City.Weather, WeatherEntity> {
    @Override
    public WeatherEntity convert(ItineraryAdditionRequest.City.Weather weather) {
        return new WeatherEntity(
                weather.main,
                weather.temperature,
                weather.pressure,
                weather.humidity,
                weather.clouds,
                LocalDate.ofInstant(weather.day, ZoneOffset.UTC)
        );
    }
}
