package com.demo.mongodb.repository;

import com.demo.mongodb.model.Role;
import com.demo.mongodb.repository.custom.RoleRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by CongDanh on 8/3/15.
 */
public interface RoleRepository extends MongoRepository<Role, String>, RoleRepositoryCustom {
    public Role findByRole(String role);
}
