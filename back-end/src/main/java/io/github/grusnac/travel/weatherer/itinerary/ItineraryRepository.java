package io.github.grusnac.travel.weatherer.itinerary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends CrudRepository<ItineraryEntity, Long> {
}
