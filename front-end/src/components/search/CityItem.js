import React from 'react';
import WeatherItem from "./WeatherItem";

export default function PreviewItem({ city, amendItinerary }) {
    const renderedWeather = Object.entries(city.weather).map(([day, weather]) => {
        return <WeatherItem
            key={day}
            city={city}
            weather={weather}
            amendItinerary={amendItinerary}
        />
    });
    return (
        <div className="ui container">
            <div>City: {city.name}</div>
            <div>Country: {city.countryCode}</div>
            <div className="ui grid">
                {renderedWeather}
            </div>
        </div>
    )
}