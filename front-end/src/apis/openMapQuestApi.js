import axios from 'axios';

const openMapQuestApi = axios.create({
    baseURL: 'http://open.mapquestapi.com/geocoding/v1',
    headers: {
        'Access-Control-Allow-Origin': '*'
    },
    params: {
        key: 'ONpQ9ZQToG2C9zCDOFO2uAaoGi3J1FtQ',
        maxResults: 1,
        ignoreLatLngInput: true
    }
});

export default openMapQuestApi;