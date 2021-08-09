package io.github.grusnac.travel.weatherer.itinerary;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;

public class ItineraryAdditionRequest {

    @NotNull(message = "Name must not be null.")
    @NotEmpty(message = "Name must not be empty.")
    public String name;
    @NotNull(message = "Cities must not be null.")
    @NotEmpty(message = "Cities must not be empty.")
    public List<City> cities;

    public static class City {
        @NotNull(message = "City must not be null.")
        public String name;
        @NotNull(message = "Country code must be null.")
        @Size(min = 2, max = 3, message = "Only country codes are allowed. I.E. US, UK, MD.")
        public String countryCode;
        @NotNull(message = "Weather must not be null")
        public Weather weather;

        public static class Weather {
            @NotNull(message = "Main status must not be null")
            public String main;
            @NotNull(message = "Temperature must not be null")
            public double temperature;
            @NotNull(message = "Temperature must not be null")
            public double pressure;
            @NotNull(message = "Humidity must not be null")
            public double humidity;
            @NotNull(message = "Clouds must not be null")
            public String clouds;
            @NotNull(message = "Clouds must not be null")
            public Instant day;
        }
    }
}
