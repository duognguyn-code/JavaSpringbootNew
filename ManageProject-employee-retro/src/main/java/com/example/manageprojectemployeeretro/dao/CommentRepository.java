package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    List<Comment> findAllByPrice(double price);
}
