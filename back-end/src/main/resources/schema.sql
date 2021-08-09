create table CITIES
(
    id           bigint primary key auto_increment,
    country_code varchar(2),
    name         varchar(25),
    weather_id   bigint
);

create table ITINERARIES
(
    id   bigint primary key auto_increment,
    name varchar(50)
);

create table ITINERARIES_CITIES
(
    itinerary_id bigint,
    city_id      bigint
);

create table WEATHER
(
    id          bigint primary key auto_increment,
    clouds      varchar(20),
    day         date,
    humidity    double,
    main        varchar(20),
    pressure    double,
    temperature double
);

alter table CITIES
    add foreign key (weather_id) references WEATHER (id);