import axios from 'axios';

const openWeatherMap = axios.create({
    baseURL: 'https://api.openweathermap.org/data/2.5',
    params: {
        appid: '78ddf4472d83510ac9a2cf459540d9bc',
        units: 'metric'
    }
});

export default openWeatherMap;