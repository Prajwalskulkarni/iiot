package com.beauto.iiotconnx.service;

import java.util.List;

import com.beauto.iiotconnx.dto.OrganizationUserDto;
import com.beauto.iiotconnx.dto.PasswordUpdateDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.dto.UserDeviceFlagDto;
import com.beauto.iiotconnx.dto.UserDto;
import com.beauto.iiotconnx.model.User;

public interface UserService {
	public StatusDto saveUser(UserDto user);
	public User getUserById(int id);
	public void deleteById(int id);
	List<UserDeviceFlagDto> getAllUsers();
	public List<User> getByEmailId(String email);
	// public User getUserById(int id);
	//public List<DeviceDetailsModel> getAllDivicesById(int id);
	public void updatePassword(PasswordUpdateDto passwordDto);
	public void loginCheck(String username,String password);
	List<OrganizationUserDto> findAllUsersByCompanyId(int companyId);
	public StatusDto updateUser(UserDto userDto);
	public void resendLink(int id);

}
