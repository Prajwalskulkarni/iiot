package com.beauto.iiotconnx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauto.iiotconnx.dto.DeviceOrganizationDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.dto.UserDevices;

@Service
public interface UserDeviceAssignService {

	public StatusDto saveUserDevices(UserDevices userDevices);
	public List<DeviceOrganizationDto> getalldevicesByid(int userId);

}