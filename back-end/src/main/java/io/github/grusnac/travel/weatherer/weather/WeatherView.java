package io.github.grusnac.travel.weatherer.weather;

import java.time.LocalDate;

public final class WeatherView {
    public String main;
    public String temperature;
    public String pressure;
    public String humidity;
    public String clouds;
    public LocalDate day;

    public static final class Builder {
        private String main;
        private String temperature;
        private String pressure;
        private String humidity;
        private String clouds;
        private LocalDate day;

        private Builder() {}

        public Builder withMain(String main) {
            this.main = main;
            return this;
        }

        public Builder withTemperature(String temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder withPressure(String pressure) {
            this.pressure = pressure;
            return this;
        }

        public Builder withHumidity(String humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder withClouds(String clouds) {
            this.clouds = clouds;
            return this;
        }

        public Builder withDay(LocalDate day) {
            this.day = day;
            return this;
        }

        public WeatherView build() {
            final WeatherView weatherView = new WeatherView();
            weatherView.main = this.main;
            weatherView.temperature = this.temperature;
            weatherView.pressure = this.pressure;
            weatherView.humidity = this.humidity;
            weatherView.clouds = this.clouds;
            weatherView.day = this.day;
            return weatherView;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
