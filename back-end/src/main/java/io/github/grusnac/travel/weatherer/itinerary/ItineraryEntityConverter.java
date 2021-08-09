package io.github.grusnac.travel.weatherer.itinerary;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Component
public class ItineraryEntityConverter implements Converter<ItineraryAdditionRequest, ItineraryEntity> {

    private final CityEntityConverter cityEntityConverter;

    public ItineraryEntityConverter(CityEntityConverter cityEntityConverter) {
        this.cityEntityConverter = cityEntityConverter;
    }

    @Override
    public ItineraryEntity convert(ItineraryAdditionRequest itineraryAdditionRequest) {
        final Set<CityEntity> cityEntities = itineraryAdditionRequest.cities.stream()
                .map(cityEntityConverter::convert)
                .collect(toSet());
        return new ItineraryEntity(itineraryAdditionRequest.name, cityEntities);
    }
}
