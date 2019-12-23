package com.redis.demo.repositoryimpl;

import static java.util.Optional.ofNullable;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.demo.model.User;
import com.redis.demo.repository.UserRepository;

@Repository
public class UserImplementation implements UserRepository{
	private HashOperations<String, String, User> operations;

	public UserImplementation(RedisTemplate<String, User> template) {
		super();
		operations = template.opsForHash();
	}

	@Override
	public Optional<User> findById(String id) {
		return ofNullable(operations.get("USER", id));
	}

	@Override
	public void save(User user) {
		operations.put("USER", user.getId(), user);
	}

	@Override
	public Map<String, User> findAll() {
		return operations.entries("USER");
	}

	@Override
	public void delete(String id) {
		operations.delete("USER", id);
	}

}
