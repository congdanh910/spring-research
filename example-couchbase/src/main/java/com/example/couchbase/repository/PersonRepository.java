package com.example.couchbase.repository;

import com.example.couchbase.model.Person;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "person")
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, String>, CustomPersonRepository {
}
