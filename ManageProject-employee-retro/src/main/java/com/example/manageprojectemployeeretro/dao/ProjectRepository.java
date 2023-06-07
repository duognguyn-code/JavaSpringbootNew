package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.Project;
import com.example.manageprojectemployeeretro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT u FROM Project u WHERE u.id = :id")
    Project getProjectById(@Param("id") long id );

    Project findProjectById(long id);
}
