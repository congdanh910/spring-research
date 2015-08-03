package com.demo.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by CongDanh on 8/3/15.
 */
@Document(collection = "roles")
public class Role implements Serializable {
    @Id
    private String id;
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Role(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
