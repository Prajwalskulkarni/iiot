package com.beauto.iiotconnx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauto.iiotconnx.model.DeviceDetailsModel;
import com.beauto.iiotconnx.repository.DeviceRepo;
import com.beauto.iiotconnx.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{
	
	@Autowired
	DeviceRepo devicerepo;

	public void saveDevice(DeviceDetailsModel device) {
		devicerepo.save(device);
		
	}

	public List<DeviceDetailsModel> getAllDevices() {
		
		return devicerepo.findAll();
	}

	public void deleteDeviceById(Long devId) {
		 devicerepo.deleteById(devId);
		
	}

}
