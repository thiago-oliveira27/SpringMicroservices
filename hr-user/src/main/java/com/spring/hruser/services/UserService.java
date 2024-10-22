package com.spring.hruser.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hruser.entities.User;
import com.spring.hruser.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new Exception("User not found"));
	}
	
	public User findByEmail(String email) throws Exception {
		Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
		return user.orElseThrow(() -> new Exception("User not found"));
	}
}
