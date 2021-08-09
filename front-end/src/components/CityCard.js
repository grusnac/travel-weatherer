import React from 'react';

export default function CityCard({ city }) {
    return (
        <div className="item">
            <div>City: {city.name}</div>
            <div>Country: {city.countryCode}</div>
            <div>Main: {city.main}</div>
            <div>Temperature: {city.temperature}</div>
            <div>Pressure: {city.pressure}</div>
            <div>Humidity: {city.humidity}</div>
            <div>Clouds: {city.clouds}</div>
            <div>Day: {new Date(city.day * 1000).toDateString()}</div>
        </div>
    )
}