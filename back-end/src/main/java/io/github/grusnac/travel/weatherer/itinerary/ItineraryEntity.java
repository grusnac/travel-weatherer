package io.github.grusnac.travel.weatherer.itinerary;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ITINERARIES")
public class ItineraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    @ManyToMany(targetEntity = CityEntity.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "ITINERARIES_CITIES",
            joinColumns = @JoinColumn(name = "itinerary_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id"))
    private List<CityEntity> cities;

    protected ItineraryEntity() {
    }

    public ItineraryEntity(LocalDate date, List<CityEntity> cities) {
        this.date = date;
        this.cities = cities;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }
}
