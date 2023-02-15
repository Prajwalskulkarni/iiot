package com.beauto.iiotconnx.util;

import java.util.Base64;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.beauto.iiotconnx.vo.UserAuthToken;

@Component
public class AuthTokenGeneration {

	public UserAuthToken generateNewToken() {
		String randomUUID = UUID.randomUUID().toString();
		String token = Base64.getEncoder().encodeToString(randomUUID.getBytes());
		UserAuthToken userAuthToken = new UserAuthToken();
		userAuthToken.setAuthToken(token);
		return userAuthToken;
	}

}
