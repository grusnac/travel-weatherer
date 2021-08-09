import React, { Component } from 'react';
import CityCard from './CityCard';
import backend from '../apis/backend';

class Itinerary extends Component {

    constructor(props) {
        super(props);
        this.state = {
            itineraryName: '',
            itinerary: this.props.itinerary
        };
    }

    saveRoute = (event) => {
        event.preventDefault()
        backend.post('/itineraries', {
            name: this.state.itineraryName,
            cities: this.state.itinerary
        });
    }

    onInputChange = event => {
        this.setState({ itineraryName: event.target.value });
    }

    render() {

        const renderedRoutes = this.state.itinerary.map((city, index) => {
            return <CityCard
                key={city.name + index}
                city={city}
            />
        });

        if (this.state.itinerary.length === 0) {
            return (
                <div className="ui container segment" >
                    <i className="plus icon huge" />
                </div>
            );
        }

        return (
            <div className="ui container segment" >
                <div className="ui horizontal list">
                    {renderedRoutes}
                </div>
                <div>
                    <form className="ui form" onSubmit={this.saveRoute}>
                        <div className="field">
                            <input
                                value={this.state.itineraryName}
                                type="text"
                                onChange={this.onInputChange}
                                placeholder="give this itinerary a name"
                            />
                            <input type="submit" value="Save Route" />
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}

export default Itinerary;