package com.mastering.spring.cap8.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Person {


	@Id        
	private  String  id;         
	private  String  name;            
	public  Person()  {//  Make  JPA  Happy 
	}        
	public  Person(String  name)  {          
		super();         
		this.name =  name;     
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
@Override
public String toString() {
	
	return name;
}
}
