package io.github.grusnac.travel.weatherer.itinerary;

import io.github.grusnac.travel.weatherer.weather.WeatherView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public final class ItineraryView {
    public long id;
    public LocalDate departureDate;
    public List<CityView> cities;

    public static final class Builder {
        private long id;
        private LocalDate departureDate;
        private List<CityView> cities;

        private Builder() {}

        private Builder(ItineraryView itineraryView) {
            this.id = itineraryView.id;
            this.departureDate = itineraryView.departureDate;
            this.cities = itineraryView.cities;
        }

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withDepartureDate(LocalDate departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public Builder withCities(List<CityView> cities) {
            this.cities = cities;
            return this;
        }

        public ItineraryView build() {
            final ItineraryView itineraryView = new ItineraryView();
            itineraryView.id = this.id;
            itineraryView.departureDate = this.departureDate;
            itineraryView.cities = this.cities;
            return itineraryView;
        }
    }

    public static Builder builder(ItineraryView itineraryView) {
        return new Builder(itineraryView);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class CityView {
        public long id;
        public String name;
        public String countryCode;
        public Map<LocalDate, WeatherView> weather;

        public static final class Builder {
            private long id;
            private String name;
            private String countryCode;
            private Map<LocalDate, WeatherView> weather;

            private Builder() {}

            private Builder(CityView cityView) {
                this.id = cityView.id;
                this.name = cityView.name;
                this.countryCode = cityView.countryCode;
                this.weather = cityView.weather;
            }

            public Builder withId(long id) {
                this.id = id;
                return this;
            }

            public Builder withName(String name) {
                this.name = name;
                return this;
            }

            public Builder withCountryCode(String countryCode) {
                this.countryCode = countryCode;
                return this;
            }

            public Builder withWeather(Map<LocalDate, WeatherView> weather) {
                this.weather = weather;
                return this;
            }

            public CityView build() {
                final CityView cityView = new CityView();
                cityView.id = this.id;
                cityView.name = this.name;
                cityView.countryCode = this.countryCode;
                cityView.weather = this.weather;
                return cityView;
            }
        }

        public static Builder builder(CityView cityView) {
            return new Builder(cityView);
        }

        public static Builder builder() {
            return new Builder();
        }
    }
}
