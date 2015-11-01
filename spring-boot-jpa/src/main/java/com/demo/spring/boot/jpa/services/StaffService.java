package com.demo.spring.boot.jpa.services;

import com.demo.spring.boot.jpa.model.Staff;

public interface StaffService {
	public Staff saveOrUpdate(Staff staff);
	public Staff findById(long id);
}
