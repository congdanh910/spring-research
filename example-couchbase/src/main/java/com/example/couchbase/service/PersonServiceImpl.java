package com.example.couchbase.service;

import com.example.couchbase.model.Person;
import com.example.couchbase.repository.CustomPersonRepository;
import com.example.couchbase.repository.PersonRepository;
import com.example.couchbase.request.PersonCreateModel;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@GraphQLApi
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @GraphQLQuery(name = "persons")
    public List<Person> getPersons () {
        return repository.findAll(PageRequest.of(0, 100)).getContent();
    }

    @GraphQLQuery(name = "hello")
    public String hello (String name) {
        return "Hello : " + name +", you are going to couchbase with : " + repository.getByTemplate();
    }

    @GraphQLQuery(name = "findById")
    public Person findById (String id) {
        return repository.findById(id).get();
    }

    @GraphQLQuery(name = "newPerson")
    public Person newPerson (PersonCreateModel person) {
        return new Person(UUID.randomUUID().toString(), person.getFirstName(), person.getLastName(), new Date());
    }

}
