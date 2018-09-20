package com.mastering.spring.cap8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastering.spring.cap8.domain.Person;
import com.mastering.spring.cap8.repository.PersonRepository;


@DataMongoTest
@RunWith(SpringRunner.class)
public class MongoRespositoryTests {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Test
	public void simpleTest() {
		personRepository.deleteAll();
		personRepository.save(new Person("first"));
		personRepository.save(new Person("second"));

		personRepository.findAll().forEach(e-> System.out.println(e));

		        

		System.out.println(personRepository.count());

	}
	
	
	@Test
	public void simpleTesTemplate() {
		
		mongoTemplate.dropCollection(Person.class);
		mongoTemplate.insert(new Person("third"));
		mongoTemplate.insert(new Person("fourd"));
		mongoTemplate.findAll(Person.class).forEach(e-> System.out.println(e));;
		

	}
}
