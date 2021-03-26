package io.github.grusnac.travel.weatherer.itinerary;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ItineraryAdditionRequest {

    @NotNull
    @Pattern(regexp = "^(\\d{4})-(\\d{2})-(\\d{2})$")
    public LocalDate departureDate;
    @NotNull
    @NotEmpty
    public List<City> cities;

    public static class City {
        @NotNull(message = "City must not be null.")
        public String name;
        @NotNull(message = "Country code must be null.")
        @Size(min = 2, max = 3, message = "Only country codes are allowed. I.E. US, UK, MD.")
        public String countryCode;
        @NotNull(message = "Weather must not be null")
        public Map<LocalDate, Weather> weather;

        public static class Weather {
            @NotNull(message = "Main status must not be null")
            public String main;
            @NotNull(message = "Temperature must not be null")
            public String temperature;
            @NotNull(message = "Temperature must not be null")
            public String pressure;
            @NotNull(message = "Humidity must not be null")
            public String humidity;
            @NotNull(message = "Clouds must not be null")
            public String clouds;
            @NotNull(message = "Clouds must not be null")
            public LocalDate day;
        }
    }
}
