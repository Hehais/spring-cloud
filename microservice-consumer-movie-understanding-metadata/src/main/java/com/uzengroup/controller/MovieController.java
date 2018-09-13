package com.uzengroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.uzengroup.model.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoverClient;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User findOne = this.restTemplate.getForObject("http://microservice-provider-user/"+id, User.class);
	    return findOne;
	}
	
	/**
	 * 查询microservice-provider-user-my-metadata服务的信息并返回
	 */
	@GetMapping("/user-instance")
	public List<ServiceInstance> showInfo(){
		return this.discoverClient.getInstances("microservice-provider-user-my-metadata");
	}
}
