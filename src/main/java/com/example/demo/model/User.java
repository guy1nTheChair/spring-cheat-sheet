package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	private int id;
	private String user;
	
	public User() {
		//DEFAULT CONSTRUCTOR
	}
	
	public User(int id, String user) {
		super();
		this.id = id;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
