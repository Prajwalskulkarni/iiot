package com.beauto.iiotconnx.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class PasswordMatch {

	public Boolean match(String sPassword, String dPassword) {
		if ( Optional.ofNullable(sPassword).isPresent() ) {
			return sPassword.equals(dPassword);
		} else
		{
			return Boolean.FALSE;
		}
	}
}
