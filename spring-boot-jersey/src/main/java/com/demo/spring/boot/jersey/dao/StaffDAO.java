package com.demo.spring.boot.jersey.dao;

import com.demo.spring.boot.jersey.model.Staff;

import java.util.List;

/**
 * Created by CongDanh on 10/11/15.
 */

public interface StaffDAO {
    public List<Staff> fetchAll();
}
