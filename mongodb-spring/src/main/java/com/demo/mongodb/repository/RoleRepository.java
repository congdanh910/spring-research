package com.demo.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.mongodb.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	public Role findByRole(String role);
}
