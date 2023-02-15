package com.beauto.iiotconnx.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.NonNull;

public class UserDto implements Serializable {

	private int id;
	private String uId;

	 @NotBlank(message = "Name is mandatory")
	private String firstName;

	 @NotBlank(message = "Name is mandatory")
	private String lastName;

	@Email(message ="{invalid email address")
	private String email;
	private Date createdOn;
	private Date updatedOn;
	private Boolean userdeletedflag;
	private String useRoleId;
	private String registration_Status;
	

	private int companyId;
	@NotBlank(message = "companyName is mandatory")
	private String companyName;
	private String password;
	@NonNull@Size(max = 10)
	private String phoneNumber;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Boolean getUserdeletedflag() {
		return userdeletedflag;
	}

	public void setUserdeletedflag(Boolean userdeletedflag) {
		this.userdeletedflag = userdeletedflag;
	}

	public String getUseRoleId() {
		return useRoleId;
	}

	public void setUseRoleId(String useRoleId) {
		this.useRoleId = useRoleId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompnayName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getRegistration_Status() {
		return registration_Status;
	}

	public void setRegistration_Status(String registration_Status) {
		this.registration_Status = registration_Status;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", uId=" + uId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", userdeletedflag="
				+ userdeletedflag + ", useRoleId=" + useRoleId + ", registration_Status=" + registration_Status
				+ ", companyId=" + companyId + ", companyName=" + companyName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	

	
	
}