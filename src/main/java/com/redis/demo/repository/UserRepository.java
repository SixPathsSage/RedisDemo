package com.redis.demo.repository;

import java.util.Map;
import java.util.Optional;

import com.redis.demo.model.User;

public interface UserRepository {
	public Optional<User> findById(String id);
	public void save(User user);
	public Map<String, User> findAll();
	public void delete(String id);
}
