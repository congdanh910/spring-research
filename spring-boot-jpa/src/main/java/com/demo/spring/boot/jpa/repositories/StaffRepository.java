package com.demo.spring.boot.jpa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.spring.boot.jpa.model.Staff;
//@Transactional(readOnly = true) ==> In fact, we can use @Transactional here but we should move it to Service layer 
public interface StaffRepository extends CrudRepository<Staff, Long> {
  
  @Modifying
  @Query("UPDATE staffs s SET s.firstName = ?2 where s.id = ?1")
  public Integer setFirstNameForStaff(long id, String firstName);
}
