package io.github.grusnac.travel.weatherer.itinerary;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ITINERARIES")
public class ItineraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "ITINERARIES_CITIES",
            joinColumns = @JoinColumn(name = "itinerary_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id"))
    private Set<CityEntity> cities;

    protected ItineraryEntity() {
    }

    public ItineraryEntity(String name, Set<CityEntity> cities) {
        this.name = name;
        this.cities = cities;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CityEntity> getCities() {
        return cities;
    }

    public void setCities(Set<CityEntity> cities) {
        this.cities = cities;
    }
}
