package com.demo.mongodb.repository.custom;

import com.demo.mongodb.model.Lead;

import java.util.List;

/**
 * Created by CongDanh on 8/2/15.
 */
public interface LeadRepositoryCustom {
    public List<Lead> findAllCustom();

    public Lead findByIdCustom(String id);

    public List<Lead> findByFirstNameOrLastNameCustom(String firstname, String lastname);

    public List<Lead> findByFirstNameOrLastNameRegexCustom(String firstname, String lastname);

    public List<Lead> findAllOrderByFirstname();
}
