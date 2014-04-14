package com.demo.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.demo.mongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String>{
	
}
