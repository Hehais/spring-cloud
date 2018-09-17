package com.uzengroup.manager;

import org.springframework.cloud.openfeign.FeignClient;

import com.uzengroup.configuration.FeignConfiguration;
import com.uzengroup.model.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClientManager {

	/**
	 * 使用feign自带的注解@RequestLine
	 * @param id
	 * @return
	 */
	@RequestLine("GET /{id}")
	public User findById(@Param("id") Long id);
}
