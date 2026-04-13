package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Get all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Get user by ID
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	// Get user by email
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	// Create a new user
	public User createUser(User user) {
		return userRepository.save(user);
	}

	// Update an existing user
	public User updateUser(Long id, User userDetails) {
		return userRepository.findById(id)
				.map(user -> {
					user.setName(userDetails.getName());
					user.setEmail(userDetails.getEmail());
					user.setPhone(userDetails.getPhone());
					user.setAddress(userDetails.getAddress());
					return userRepository.save(user);
				})
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}

	// Delete user by ID
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	// Check if user exists by email
	public boolean existsByEmail(String email) {
		return userRepository.findByEmail(email).isPresent();
	}
}
