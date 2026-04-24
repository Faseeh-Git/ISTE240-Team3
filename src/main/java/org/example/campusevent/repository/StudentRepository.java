// Haya Khan 746008798
package org.example.campusevent.repository;

import org.example.campusevent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {

    List<Student> findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.major = :major")
    List<Student> findByMajor(@Param("major") String major);

    @Modifying
    @Query("UPDATE Student s SET s.email = :email WHERE s.studentID = :id")
    long updateEmailById(@Param("id") Long id, @Param("email") String email);

    boolean existsByEmail(String email);
}

