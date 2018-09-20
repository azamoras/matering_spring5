package com.mastering.spring.cap8.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mastering.spring.cap8.domain.Person;


@RepositoryRestResource(collectionResourceRel= "persons", path = "persons")
public interface PersonRepository extends MongoRepository<Person, Long> {
	
	Optional<Person> findByName(String name);

}
