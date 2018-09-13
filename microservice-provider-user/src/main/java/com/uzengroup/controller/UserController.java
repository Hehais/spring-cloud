package com.uzengroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uzengroup.model.User;
import com.uzengroup.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Value("${server.port}")
	private String port;
	
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User user = new User();
		user.setId(id);
		user.setName("张三");
		user.setAge(25);
		user.setUsername("这是端口=="+port);
//		User findOne = this.userRepository.getOne(id);
		return user;
	}
}
