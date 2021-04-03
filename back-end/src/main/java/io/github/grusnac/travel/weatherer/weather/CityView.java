package io.github.grusnac.travel.weatherer.weather;

import java.time.LocalDate;
import java.util.Map;

public final class CityView {
    public long id;
    public String name;
    public String countryCode;
    public Map<LocalDate, WeatherView> weather;

    public static final class Builder {
        private long id;
        private String name;
        private String countryCode;
        private Map<LocalDate, WeatherView> weather;

        private Builder() {
        }

        private Builder(CityView cityView) {
            this.id = cityView.id;
            this.name = cityView.name;
            this.countryCode = cityView.countryCode;
            this.weather = cityView.weather;
        }

        public CityView.Builder withId(long id) {
            this.id = id;
            return this;
        }

        public CityView.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public CityView.Builder withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public CityView.Builder withWeather(Map<LocalDate, WeatherView> weather) {
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

    public static CityView.Builder builder(CityView cityView) {
        return new CityView.Builder(cityView);
    }

    public static CityView.Builder builder() {
        return new CityView.Builder();
    }
}