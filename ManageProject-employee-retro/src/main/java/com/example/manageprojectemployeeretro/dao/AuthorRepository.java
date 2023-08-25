package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
