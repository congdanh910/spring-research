package com.demo.mongodb.repository.custom.impl;

import com.demo.mongodb.model.Lead;
import com.demo.mongodb.repository.custom.LeadRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by CongDanh on 8/2/15.
 * Need to save this information in mind the name conversion need to correct with Interface and Class
 * 1. LeadRepositoryCustom : the custom class
 * 2. LeadRepositoryImpl : the custom implementation ( "..Impl" will spring validate to get the custom class
 * 3. LeadRepository : the main repository class
 */
public class LeadRepositoryImpl implements LeadRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Lead> findAllCustom() {
        return mongoTemplate.findAll(Lead.class);
    }

    @Override
    public Lead findByIdCustom(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Lead.class);
    }

    @Override
    public List<Lead> findByFirstNameOrLastNameCustom(String firstname, String lastname) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("firstname").is(firstname), Criteria.where("lastname").is(lastname));
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Lead.class);
    }

    @Override
    public List<Lead> findByFirstNameOrLastNameRegexCustom(String firstname, String lastname) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("firstname").regex(firstname), Criteria.where("lastname").regex(lastname));
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Lead.class);
    }

    @Override
    public List<Lead> findAllOrderByFirstname() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "firstname"));
        return mongoTemplate.find(query, Lead.class);
    }
}
