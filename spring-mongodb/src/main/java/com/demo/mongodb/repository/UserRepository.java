package com.demo.mongodb.repository;

import com.demo.mongodb.model.Role;
import com.demo.mongodb.model.User;
import com.demo.mongodb.repository.custom.UserRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by CongDanh on 8/3/15.
 */
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {
    public List<User> findByRole(Role role);
}
