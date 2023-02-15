package com.beauto.iiotconnx.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginRequestDto {
 
	private String email;
	private String password;
	
}
