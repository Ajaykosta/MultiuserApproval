package com.company.approval.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.approval.entity.User;
import com.company.approval.repository.UserRepository;

@Service
public class AuthServiceImpl implements IAuthService {
	@Autowired
	private UserRepository userRepository;

	public String signup(User user) {
		userRepository.save(user);
		return "User registered successfully!";
	}

	public String login(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		return existingUser.isPresent() ? "Login successful!" : "Invalid credentials!";
	}
}