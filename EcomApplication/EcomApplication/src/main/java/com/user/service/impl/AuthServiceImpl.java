package com.user.service.impl;

import java.time.LocalDateTime;


import org.springframework.stereotype.Service;

import com.user.dto.request.LoginRequest;
import com.user.dto.request.RegisterRequest;
import com.user.dto.response.AuthResponse;
import com.user.entity.User;
import com.user.entity.enums.Role;
import com.user.exception.InvalidCredentialsException;
import com.user.exception.UserAlreadExistsException;
import com.user.mapper.UserMapper;
import com.user.repository.UserRepository;
import com.user.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;

	public AuthServiceImpl(UserRepository ur) {
		this.userRepository = ur;
	}

	@Override
	public AuthResponse register(RegisterRequest request) {

		if (userRepository.existsByEmail(request.getEmail())) {
			throw new UserAlreadExistsException("User Alread exists with email");
		}

		User user = UserMapper.toEntity(request);
		
		user.setCreatedAt(LocalDateTime.now());
		user.setRole(Role.CUSTOMER);
		user.setEnabled(true);

		User savedUser = userRepository.save(user);

		AuthResponse authResponse = ResponseMapper.toAuthReponse(savedUser);
		authResponse.setToken("User Registed");
		
		return authResponse;
	}

	@Override
	public AuthResponse login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));

		if (!user.getPassword().equals(request.getPassword())) {
			throw new InvalidCredentialsException("Invalid email or password");
		}

		AuthResponse auth = ResponseMapper.toAuthReponse(user);
		
		auth.setToken("Login_Success");

		return auth;

	}

}
