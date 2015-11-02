package com.demo.spring.boot.jpa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.spring.boot.jpa.model.Staff;
/*
   @Transactional(readOnly = true) ==> In fact, we can use @Transactional here but we should move it to Service layer 
    http://stackoverflow.com/questions/19716673/spring-data-jpa-transactional
      The transaction configuration at the repositories will be neglected 
      then as the outer transaction configuration determines the actual one used.
 */
public interface StaffRepository extends CrudRepository<Staff, Long> {
  
  @Modifying
  @Query("UPDATE staffs s SET s.firstName = ?2 where s.id = ?1")
  public Integer setFirstNameForStaff(long id, String firstName);
}
