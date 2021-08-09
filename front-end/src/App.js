import './App.css';
import React from 'react'
import Itinerary from './components/Itinerary';
import SearchBar from './components/search/SarachBar';
import SearchPreview from './components/search/SearchPreview';

export default class App extends React.Component {

    state = { itinerary: [], searchResult: null };

    amendItinerary = (city) => {
        let cities = this.state.itinerary;
        cities.push(city);
        this.setState({ cities });
    }

    setSearchResult = city => {
        this.setState({ searchResult: city });
    }

    render() {
        return (
            <div className="ui container segment">
                <div>
                    <SearchBar onSearchSubmit={this.setSearchResult} />
                    <SearchPreview
                        city={this.state.searchResult}
                        amendItinerary={this.amendItinerary}
                    />
                </div>
                <hr/>
                <div>
                    <Itinerary itinerary={this.state.itinerary} />
                </div>
            </div>
        );
    }
};