// Syed Faseeullah | 422000932

package org.example.campusevent.repository;

import org.example.campusevent.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    // find by student name
    List<Enrollment> findByStudentName(String studentName);

    // JPQL query — find by major in student
    @Query("SELECT e FROM Enrollment e WHERE e.eventName = :eventName")
    List<Enrollment> findByEventName(@Param("eventName") String eventName);

    // update event name by ID
    @Modifying
    @Query("UPDATE Enrollment e SET e.eventName = :eventName WHERE e.enrollmentId = :id")
    void updateEventNameById(@Param("id") int id, @Param("eventName") String eventName);

    // check if enrollment exists by student name
    boolean existsByStudentName(String studentName);
}