create table CITIES
(
    id           bigint primary key,
    country_code varchar(2),
    name         varchar(25)
);

create table CITIES_WEATHER
(
    city_id    bigint,
    weather_id bigint
);

create table ITINERARIES
(
    id   bigint primary key,
    date date
);

create table ITINERARIES_CITIES
(
    itinerary_id bigint,
    city_id      bigint
);

create table WEATHER
(
    id          bigint primary key,
    clouds      varchar(20),
    day         date,
    humidity    int,
    main        varchar(20),
    pressure    int,
    temperature int
);