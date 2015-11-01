package com.demo.spring.boot.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.spring.boot.jpa.model.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long> {

}
