import React, { Component } from 'react';
import openMapQuestApi from '../../apis/openMapQuestApi';
import openWeatherMap from '../../apis/openWeatherMap';

class SearchBar extends Component {
    state = { term: '' };

    onFormSubmit = async event => {
        event.preventDefault();
        const cityLocation = await this.getCityLocation(this.state.term);
        const city = await this.getCityWeather(cityLocation);
        this.props.onSearchSubmit(city);
    }

    getCityLocation = async cityName => {
        const { data } = await openMapQuestApi.get('/address', {
            params: {
                location: cityName,
            }
        });
        
        return {
            longitude: data.results[0].locations[0].latLng.lng,
            latitude: data.results[0].locations[0].latLng.lat,
            countyCode: data.results[0].locations[0].adminArea1,
            name: cityName
        };
    }

    getCityWeather = async cityLocation => {
        const { data } = await openWeatherMap.get('/onecall', {
            params: {
                lon: cityLocation.longitude,
                lat: cityLocation.latitude,
                exclude: 'current,minutely,hourly'
            }
        });

        return {
            name: cityLocation.name,
            countryCode: cityLocation.countyCode,
            weather: this.extractCityWeather(data.daily)
        };
    }

    extractCityWeather = (cityWeatherData) => {
        const weather = [];
        cityWeatherData.forEach(day => {
            weather.push(
                {
                    main: day.weather[0].main,
                    temperature: day.temp.day,
                    pressure: day.pressure,
                    humidity: day.humidity,
                    clouds: day.clouds,
                    day: (day.dt)
                }
            );
        });
        return weather;
    }

    onInputChange = event => {
        this.setState({ term: event.target.value });
    }

    render() {
        return (
            <div className="search-bar">
                <form className="ui form" onSubmit={this.onFormSubmit}>
                    <div className="field">
                        <input
                            value={this.state.term}
                            type="text"
                            onChange={this.onInputChange}
                            placeholder="type a city"
                        />
                    </div>
                </form>
            </div>
        );
    }
}

export default SearchBar;