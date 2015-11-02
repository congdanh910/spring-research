package com.demo.spring.boot.jpa.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.boot.jpa.model.Staff;
import com.demo.spring.boot.jpa.repositories.StaffRepository;
import com.demo.spring.boot.jpa.services.StaffService;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepo;

	@Override
	public Staff saveOrUpdate(Staff staff) {
		return staffRepo.save(staff);
	}

	@Override
	public Staff findById(long id) {
		return staffRepo.findOne(id);
	}

  @Override
  @Transactional(readOnly = false)
  public Integer setFirstNameForStaff(long id, String firstName) {
    return staffRepo.setFirstNameForStaff(id, firstName);
  }

}
