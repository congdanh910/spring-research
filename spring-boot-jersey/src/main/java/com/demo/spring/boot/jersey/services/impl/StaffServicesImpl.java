package com.demo.spring.boot.jersey.services.impl;

import com.demo.spring.boot.jersey.dao.StaffDAO;
import com.demo.spring.boot.jersey.model.Staff;
import com.demo.spring.boot.jersey.services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CongDanh on 10/11/15.
 */
@Service
public class StaffServicesImpl implements StaffServices {
    @Autowired
    private StaffDAO staffDAO;

    @Override
    public List<Staff> fetchAll() {
        return staffDAO.fetchAll();
    }
}
