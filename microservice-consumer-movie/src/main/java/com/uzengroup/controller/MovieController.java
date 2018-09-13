package com.uzengroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.uzengroup.model.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User findOne = this.restTemplate.getForObject("http://microservice-provider-user/"+id, User.class);
	    return findOne;
	}
}
