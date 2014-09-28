package com.demo.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.mongodb.model.Lead;

public interface LeadsRepository extends MongoRepository<Lead, String> {
	
	// The full text search is using MongoRepository regex. Note : we need to use '$options':'i'.
	@Query("{firstname : {'$regex' : ?0, '$options':'i'}}")
	public List<Lead> findByFirstname(String firstname);
}
