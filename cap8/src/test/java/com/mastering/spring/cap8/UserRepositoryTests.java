package com.mastering.spring.cap8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastering.spring.cap8.domain.User;
import com.mastering.spring.cap8.repository.UserRepository;

@DataJpaTest 
@RunWith(SpringRunner.class)
public class UserRepositoryTests {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void testing_sort_stuff() throws Exception {

		Sort sort = new Sort(Sort.Direction.DESC, "name").and(new Sort(Sort.Direction.ASC, "userid"));
		Iterable<User> users = userRepository.findAll(sort);
		
	   users.forEach(u -> System.out.println(u));
	   
	}
	
	@Test
	public void using_pageable_stuff() throws Exception {

		PageRequest pageable = PageRequest.of(0, 2);
		Page<User> page = userRepository.findAll(pageable);
		System.out.println(page);
		System.out.println(page.getContent());

	
	   
	}

}
