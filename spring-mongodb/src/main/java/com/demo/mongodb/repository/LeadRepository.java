package com.demo.mongodb.repository;

import java.util.List;

import com.demo.mongodb.repository.custom.LeadRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.mongodb.model.Lead;

public interface LeadRepository extends MongoRepository<Lead, String>, LeadRepositoryCustom {

    // The full text search is using MongoRepository regex. Note : we need to use '$options':'i'.
    @Query("{firstname : {'$regex' : ?0, '$options':'i'}}")
    public List<Lead> findByFirstname(String firstname);

    public List<Lead> findByFirstnameLikeOrderByFirstnameDesc(String firstname);
}
