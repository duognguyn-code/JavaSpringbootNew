package com.example.manageprojectemployeeretro.utils;

import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {
    public static Specification<User> hasFirstNameLike(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.<String>get("firstName"), "%" + name + "%");
    }

    public static Specification<User> hasLastName(String name) {
        return (root, query, cb) ->
                cb.equal(root.<String>get("lastName"), name);
    }
}
