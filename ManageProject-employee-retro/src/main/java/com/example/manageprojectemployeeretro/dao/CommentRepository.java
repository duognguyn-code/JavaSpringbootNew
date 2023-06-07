package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
