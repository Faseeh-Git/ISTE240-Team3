// Name: Brendon ID: 761008604

package org.example.campusevent.repository;

import org.example.campusevent.model.Event;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.eventName = :name")
    List<Event> findByEventName(@Param("name") String name);

    @Modifying
    @Query("UPDATE Event e SET e.eventLocation = :location WHERE e.eventID = :id")
    int updateLocationById(@Param("id") Long id,
                           @Param("location") String location);
}