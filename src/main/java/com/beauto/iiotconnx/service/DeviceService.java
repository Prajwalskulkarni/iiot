package com.beauto.iiotconnx.service;

import java.util.List;

import com.beauto.iiotconnx.model.DeviceDetailsModel;

public interface DeviceService {
	
	public void saveDevice(DeviceDetailsModel device);
	List<DeviceDetailsModel> getAllDevices();
	public void deleteDeviceById(Long devId);

}
