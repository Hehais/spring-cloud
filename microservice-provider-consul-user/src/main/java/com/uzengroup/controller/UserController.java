package com.uzengroup.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@GetMapping("/findByIdAndAge/{id}/{age}")
	public User findByIdAndAge(@PathVariable("id") Long id,@PathVariable("age") Integer age) {
		User user = new User();
		user.setId(id);
		user.setName("张三");
		user.setAge(age);
		user.setUsername("这是端口=="+port);
//		User findOne = this.userRepository.getOne(id);
		return user;
	}
	
	@GetMapping("/findByIdAndAge2")
	public User findByIdAndAge2(@RequestParam("id") Long id,@RequestParam Integer age) {
		User user = new User();
		user.setId(id);
		user.setName("张三");
		user.setAge(age);
		user.setUsername("这是端口=="+port);
//		User findOne = this.userRepository.getOne(id);
		return user;
	}
	
	@PostMapping("/findByUser")
	public User findByUser(@RequestBody User user) {
		user.setUsername("这是端口=="+port);
		user.setBalance(new BigDecimal("999999999"));
//		User findOne = this.userRepository.getOne(id);
		return user;
	}
	
	@GetMapping("/getMapInfo")
	public Map<String,String> getMapInfo(@RequestParam Map<String,String> map){
		System.out.println("id===="+map.get("id"));
		System.out.println("age===="+map.get("age"));
		map.put("name", "hehai");
		return map;
	}
}
