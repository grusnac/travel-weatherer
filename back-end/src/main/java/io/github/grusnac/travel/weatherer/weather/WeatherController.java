package io.github.grusnac.travel.weatherer.weather;

import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final RestTemplate restTemplate;
    private final ConversionService conversionService;

    public WeatherController(RestTemplate restTemplate, ConversionService conversionService) {
        this.restTemplate = restTemplate;
        this.conversionService = conversionService;
    }

    @GetMapping(params = "city")
    public CityView getWeather(@RequestParam("city") String city) {
        return getWeather(city, LocalDate.now().plusDays(1));
    }

    @GetMapping(params = {"city", "date"})
    public CityView getWeather(@RequestParam("city") String city, @RequestParam("date") LocalDate date) {
        return CityView.builder()
                .withId(1L)
                .withCountryCode("AU")
                .withName(city)
                .withWeather(Map.of(date, WeatherView.builder()
                        .withMain("Clouds")
                        .withTemperature("300.15")
                        .withPressure("1007")
                        .withHumidity("74")
                        .withClouds("40")
                        .withDay(LocalDate.now().plusDays(1))
                        .build()))
                .build();
    }
}
