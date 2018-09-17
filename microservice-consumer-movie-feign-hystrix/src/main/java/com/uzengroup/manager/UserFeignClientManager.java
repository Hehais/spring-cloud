package com.uzengroup.manager;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uzengroup.model.User;

@FeignClient(name = "microservice-provider-user",fallback = SchedualServiceHiHystric.class )
public interface UserFeignClientManager {

	/**
	 * 单个参数请求
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	/**
	 * 多参数使用@RequestParam，服务提供者也使用@PathVariable接收参数
	 * @param id
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/findByIdAndAge/{ids}/{ages}",method = RequestMethod.GET)
	public User findByIdAndAge(@RequestParam("ids") Long ids,@RequestParam("ages") Integer age);

	/**
	 * 多参数使用@RequestParam，服务提供者也使用@RequestParam接收参数
	 * @param id
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/findByIdAndAge2",method = RequestMethod.GET)
	public User findByIdAndAge2(@RequestParam("id") Long id,@RequestParam("age") Integer age);

	/**
	 * 对象参数post请求：@RequestBody，服务提供者必须使用@RequestBody接收此对象
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/findByUser",method = RequestMethod.GET)
	public User findByUser(@RequestBody User user);
	
	/**
	 * 多参数封装
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "getMapInfo",method = RequestMethod.GET)
	public Map<String,String> getMapInfo(@RequestParam Map<String,String> map);

}
