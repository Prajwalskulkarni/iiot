package com.beauto.iiotconnx.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginResponseDto {

	private String roleId;
	private int companyId;
	private String username;
	private String code;
	private String meassage;
	private int id;
	
}
