package io.github.grusnac.travel.weatherer.weather;

import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

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
    public WeatherView getWeather(@RequestParam("city") String city) {
        return WeatherView.builder()
                .withMain("Clouds")
                .withTemperature("300.15")
                .withPressure("1007")
                .withHumidity("74")
                .withClouds("40")
                .withDay(LocalDate.ofEpochDay(1485790200))
                .build();
    }

    @GetMapping(params = {"city", "date"})
    public WeatherView getWeather(@RequestParam("city") String city, @RequestParam("date") LocalDate date) {
        return WeatherView.builder()
                .withMain("Clouds")
                .withTemperature("300.15")
                .withPressure("1007")
                .withHumidity("74")
                .withClouds("40")
                .withDay(date)
                .build();
    }
}
