- POST /itineraries/ - Create a new itinerary
    ```
    [
        {
            cityView: String
        }
    ]
    ```
- GET /itineraries/{id} - Retrieve one itinerary
    ```
    {
        id: Long,
        departureDate: LocalDate,
        cities: [
            {
                id: Long,
                cityView: String,
                countryCode: String,
                weather: [
                    {
                        id: Long,
                        main: String,
                        temperature: String,
                        pressure: String,
                        humidity: String,
                        clouds: String,
                        day: LocalDate
                    },
                    ...
                ]
            },
            ...
        ]
    }
    ```
- GET /itineraries/ - Retrieve all itineraries
    ```
    [
        {
            id: Long,
            departureDate: LocalDate,
            cities: [
                {
                    id: Long,
                    cityView: String,
                    countryCode: String,
                    weather: [
                        {
                            id: Long,
                            main: String,
                            temperature: String,
                            pressure: String,
                            humidity: String,
                            clouds: String,
                            day: LocalDate
                        },
                        ....
                    ]
                },
                ...
            ]
        }
    ]
    ```
- GET /weather?cityView=Chisinau
    ```
    {
        cityView: String,
        weather: {
            temperature: String,
            ...
        }
    }    
    ```