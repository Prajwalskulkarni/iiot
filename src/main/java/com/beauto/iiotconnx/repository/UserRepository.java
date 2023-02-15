package com.beauto.iiotconnx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User getUserById(int id);

	User findByEmail(String email);

	List<User> getByEmail(String email);

	//public User getAllDivicesById(int id);
	
	public User findByEmailAndPassword(String email,String password);
	//public User findAllUsersByCompanyId(OrganizationUserDto organizationUserDto,int companyId);

	List<User> findAllUsersByCompanyId(int companyId);

	User findByPassword(String password);
	
	//@Query("SELECT new com.beauto.iiotconnx.dto.GetAllDeviceDto(u.id, d.devId, d.deviceName, d.productName, d.deviceStatus, u.firstName) FROM User u JOIN u.devices d")
	//public List<GetAllDeviceDto> getDeviceInfo();
	
	
}

