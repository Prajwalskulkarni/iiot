package com.beauto.iiotconnx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.DeviceDetailsModel;
import com.beauto.iiotconnx.model.Organization;

@Repository("DeviceDetailsRepo")
public interface DeviceDetailsRepo extends JpaRepository<DeviceDetailsModel, Long> {

	//@Query("SELECT device FROM DeviceDetailsModel device WHERE device.deviceStatus = 'active'")
	//public List<DeviceDetailsModel> findAllActiveDevice();

	List<DeviceDetailsModel> findByOrg(Organization org);
	DeviceDetailsModel findBydevId(long devId);
	void deleteBydevId(Long devId);
	
	
	
	
	
	
}
