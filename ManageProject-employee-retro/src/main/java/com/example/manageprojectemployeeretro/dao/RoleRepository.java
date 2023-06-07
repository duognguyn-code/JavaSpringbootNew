package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT u FROM Role u WHERE u.id = :id")
    Role getRoleById(@Param("id") long id );
}
