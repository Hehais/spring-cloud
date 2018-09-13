package com.uzengroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uzengroup.manager.UserFeignClientManager;
import com.uzengroup.model.User;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClientManager userFeignClientManager;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User findOne = this.userFeignClientManager.findById(id);
	    return findOne;
	}
}
