package com.uzengroup.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/findByIdAndAge/{id}/{age}")
	public User findByIdAndAge(@PathVariable("id") Long id,@PathVariable("age") Integer age) {
		User findOne = this.userFeignClientManager.findByIdAndAge(id,age);
	    return findOne;
	}
	
	@GetMapping("/findByIdAndAge2/{id}/{age}")
	public User findByIdAndAge2(@PathVariable("id") Long id,@PathVariable("age") Integer age) {
		User findOne = this.userFeignClientManager.findByIdAndAge2(id,age);
	    return findOne;
	}
	
	@GetMapping("/findByUser/{id}/{age}")
	public User findByUser(@PathVariable("id") Long id,@PathVariable("age") Integer age) {
		User user = new User();
		user.setId(id);
		user.setName("贺海");
		user.setAge(25);
		user = this.userFeignClientManager.findByUser(user);
	    return user;
	}
	
	
	@GetMapping("/getMapInfo/{id}/{age}")
	public Map<String,String> getMapInfo(@PathVariable("id") Long id,@PathVariable("age") Integer age) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id.toString());
		map.put("age", age.toString());
		map = this.userFeignClientManager.getMapInfo(map);
	    return map;
	}
}
