package io.github.grusnac.travel.weatherer.itinerary;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CityEntityConverter implements Converter<ItineraryAdditionRequest.City, CityEntity> {

    private final WeatherEntityConverter weatherEntityConverter;

    public CityEntityConverter(WeatherEntityConverter weatherEntityConverter) {
        this.weatherEntityConverter = weatherEntityConverter;
    }

    @Override
    public CityEntity convert(ItineraryAdditionRequest.City city) {
        return new CityEntity(
                city.name,
                city.countryCode,
                weatherEntityConverter.convert(city.weather)
        );
    }
}
