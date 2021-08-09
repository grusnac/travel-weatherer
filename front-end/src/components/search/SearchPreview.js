import React from 'react';
import CityItem from './CityItem';

const SearchPreview = ({ city, amendItinerary }) => {
    if (city === null) {
        return (
            <div className="ui container segment">
            <i className="plus icon huge" />
        </div>
        );
    }

    return (
        <div className="ui container segment">
            <CityItem city={city} amendItinerary={amendItinerary} />
        </div>
    );
}

export default SearchPreview;