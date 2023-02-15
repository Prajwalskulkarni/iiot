package com.beauto.iiotconnx.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class OrganizationUserDto {
	private int id;
	private String uId;

	// @NotBlank(message = "Name is mandatory")
	private String firstName;

	// @NotBlank(message = "Name is mandatory")
	private String lastName;

	// @Email(message ="{invalid email address")
	private String email;
	private Date createdOn;
	private Date updatedOn;
	private Boolean userdeletedflag;
	private String useRoleId;
	private int companyId;
	private String companyName;
	private String password;
	private String phoneNumber;
	private String flag;
	private String registration_Status;
}
