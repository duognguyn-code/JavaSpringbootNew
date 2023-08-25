package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
}
