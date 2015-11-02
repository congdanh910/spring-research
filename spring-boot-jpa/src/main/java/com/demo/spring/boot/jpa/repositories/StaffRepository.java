package com.demo.spring.boot.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.spring.boot.jpa.model.Staff;

/*
   @Transactional(readOnly = true) ==> In fact, we can use @Transactional here but we should move it to Service layer 
    http://stackoverflow.com/questions/19716673/spring-data-jpa-transactional
      The transaction configuration at the repositories will be neglected 
      then as the outer transaction configuration determines the actual one used.
 */
public interface StaffRepository extends CrudRepository<Staff, Long> {

	// Using position to determine parameters for the query
	@Modifying
	@Query("UPDATE staffs s SET s.firstName = ?2 where s.id = ?1")
	public Integer setFirstNameForStaff(long id, String firstName);

	// Using @Param to determine parameter for the query // if we use nativeQuery = true, the query would be SQL directly.
	@Modifying
	@Query(value = "SELECT st FROM staffs as st WHERE st.firstName LIKE :firstName%")
	public List<Staff> findByFirstName(@Param("firstName") String firstName);
}
