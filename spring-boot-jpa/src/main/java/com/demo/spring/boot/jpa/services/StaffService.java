package com.demo.spring.boot.jpa.services;

import java.util.List;

import com.demo.spring.boot.jpa.model.Staff;

public interface StaffService {
  public Staff saveOrUpdate(Staff staff);

  public Staff findById(long id);

  public Integer setFirstNameForStaff(long id, String firstName);
  
  public List<Staff> findByFirstName(String firstName);
}
