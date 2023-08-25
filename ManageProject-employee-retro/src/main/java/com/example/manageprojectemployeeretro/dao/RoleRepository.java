package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.config.ERole;
import com.example.manageprojectemployeeretro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT u FROM Role u WHERE u.id = :id")
    Role getRoleById(@Param("id") long id );

    @Query(value = "select r.name from User u join Author a on u.id = a.id\n" +
            "join Role r on a.id=r.id\n" +
            "where u.email = ?1")
    List<String> findRoleNameByUser(String email);

    Optional<Role> findByName(ERole name);

}
