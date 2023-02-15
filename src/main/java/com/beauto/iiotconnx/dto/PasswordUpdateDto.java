package com.beauto.iiotconnx.dto;

public class PasswordUpdateDto {
	private int id;
	private String password;
	private String confirmPassword;
	private String registration_Status;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRegistration_Status() {
		return registration_Status;
	}
	public void setRegistration_Status(String registration_Status) {
		this.registration_Status = registration_Status;
	}
	@Override
	public String toString() {
		return "PasswordUpdateDto [id=" + id + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", registration_Status=" + registration_Status + "]";
	}
	
	
}
