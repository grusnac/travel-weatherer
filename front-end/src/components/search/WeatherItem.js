import React from 'react';

export default function WeatherItem({ city , weather, amendItinerary }) {

    const addCity = () => {
        const itinerayNode = {};
        itinerayNode['name'] = city.name;
        itinerayNode['countryCode'] = city.countryCode;
        itinerayNode['weather'] = {
            main: weather.main,
            temperature: weather.temperature,
            pressure: weather.pressure,
            humidity: weather.humidity,
            clouds: weather.clouds,
            day: weather.day
        };
        amendItinerary(itinerayNode);
    }

    return (
        <div className="four wide column" onClick={() => addCity()}>
            <div>Main: {weather.main}</div>
            <div>Temperature: {weather.temperature}</div>
            <div>Pressure: {weather.pressure}</div>
            <div>Humidity: {weather.humidity}</div>
            <div>Clouds: {weather.clouds}</div>
            <div>Day: {new Date(weather.day * 1000).toDateString()}</div>
        </div>
    )
}