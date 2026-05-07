package com.user.service.impl;

import com.user.dto.response.AuthResponse;
import com.user.entity.User;

public class ResponseMapper {
	
	public static AuthResponse toAuthReponse(User user) {
		AuthResponse authResponse = new AuthResponse();
		authResponse.setEmail(user.getEmail());
		authResponse.setRole(user.getRole().name());
		return authResponse;

	}

}
