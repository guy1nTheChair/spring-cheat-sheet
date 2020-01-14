package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class Controller {

	/**
	 * Dummy Method to check if API is up and running
	 */
	@GetMapping("/dummy")
	public String dummyMethod() {
		return "API Up and Running succesfully!!";
	}

	/*
	 * Handle a post request by receiving two string and returning
	 * a String array
	 */
	@PostMapping("/doPost")
	public String[] doPost(@RequestParam String str1, @RequestParam String str2) {
		return new String[] { str1, str2 };
	}

	/**
	 * Method to accept 2 attributes and add them to a list of objects and return
	 * the list of objects to User
	 */
	@PostMapping("/postUser")
	public User[] postUser(@RequestParam int id, @RequestParam String name) {
		User u = new User();
		u.setId(id);
		u.setUser(name);
		return new User[] { u };
	}

	/**
	 * Method to accept a key value pair object of size n and return the object as a
	 * Map to the user
	 * 
	 * @throws ParseException
	 */
	@PostMapping("/toMap")
	public Map<String, Object> toMap(@RequestBody Object input) throws ParseException {
		GsonJsonParser parser = new GsonJsonParser();
		Map<String, Object> map = parser.parseMap(input.toString());
		return map;
	}

	/**
	 * Method to accept multiple objects as key value pairs of size n and return the
	 * List of objects to the user
	 */

	@PostMapping("/toList")
	public List<Object> toList(@RequestBody Object input) {
		GsonJsonParser parser = new GsonJsonParser();
		List<Object> list = parser.parseList(input.toString());
		return list;
	}
}
