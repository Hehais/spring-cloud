package com.uzengroup.manager;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.uzengroup.model.User;

@Component
public class SchedualServiceHiHystric implements UserFeignClientManager {

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(id);
		user.setName("错误===="+id);
		return user;
	}

	@Override
	public User findByIdAndAge(Long ids, Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByIdAndAge2(Long id, Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getMapInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
