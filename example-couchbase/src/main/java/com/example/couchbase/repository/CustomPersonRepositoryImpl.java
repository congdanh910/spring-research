package com.example.couchbase.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

public class CustomPersonRepositoryImpl implements CustomPersonRepository {

    @Autowired
    CouchbaseTemplate template;

    @Override
    public String getByTemplate () {
        return "Couchbase bucket : " + template.getCouchbaseBucket().name();
    }

}
