// Name: Brendon ID: 761008604

package org.example.campusevent.repository;

import org.example.campusevent.model.Admin;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a FROM Admin a WHERE a.adminName = :name")
    List<Admin> findByAdminName(@Param("name") String name);

    @Modifying
    @Query("UPDATE Admin a SET a.role = :role WHERE a.adminID = :id")
    int updateRoleById(@Param("id") Long id,
                       @Param("role") String role);
}