package com.mastering.spring.cap8.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;


@Entity
public class Todo {
	
	@Id
	private long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private User user;
	
	private String title;
	
	@Size(min=9, message = "Enter atleast 10 Characters.")
	private String desc;
	
	@Past
	private Date targetDate;
	private boolean isDone;
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}

	public Todo(int id, String desc, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
