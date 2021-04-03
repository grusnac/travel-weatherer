package io.github.grusnac.travel.weatherer.itinerary;

import io.github.grusnac.travel.weatherer.weather.CityView;
import io.github.grusnac.travel.weatherer.weather.WeatherView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/itineraries")
public class ItineraryController {

    @GetMapping("/{id}")
    public ItineraryView getItinerary(@PathVariable final long id) {
        return ItineraryView.builder()
                .withId(id)
                .withDepartureDate(LocalDate.now().plusDays(1))
                .withCities(List.of(CityView.builder()
                        .withId(1L)
                        .withCountryCode("AU")
                        .withName("Cairns")
                        .withWeather(Map.of(LocalDate.now().plusDays(1), WeatherView.builder()
                                .withMain("Clouds")
                                .withTemperature("300.15")
                                .withPressure("1007")
                                .withHumidity("74")
                                .withClouds("40")
                                .withDay(LocalDate.now().plusDays(1))
                                .build()))
                        .build()))
                .build();
    }

    @GetMapping()
    public Collection<ItineraryView> getItineraries() {
        return List.of(getItinerary(1L));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addItineraries(@Valid ItineraryAdditionRequest itineraryAdditionRequest) {
        return ResponseEntity.ok().build();
    }
}
