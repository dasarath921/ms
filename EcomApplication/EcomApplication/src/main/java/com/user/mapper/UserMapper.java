package com.user.mapper;

import com.user.dto.request.RegisterRequest;
import com.user.dto.response.AuthResponse;
import com.user.dto.response.UserResponseDto;
import com.user.entity.User;

public class UserMapper {

	public static User toEntity(RegisterRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		return user;
	}

	public static UserResponseDto toResponse(User user) {
		UserResponseDto auth = new UserResponseDto();
		auth.setEmail(user.getEmail());
		auth.setRole(user.getRole().name());
		auth.setName(user.getName());
		auth.setId(user.getUserid());
		return auth;
	}



}
