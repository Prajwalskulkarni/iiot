package com.beauto.iiotconnx.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.beauto.iiotconnx.dto.DeviceDataRequestDto;
import com.beauto.iiotconnx.dto.DeviceDeactivateRequestDto;
import com.beauto.iiotconnx.dto.DeviceDetailRequestDto;
import com.beauto.iiotconnx.dto.DeviceOrganizationDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.model.DeviceDetailsModel;

public interface DeviceDetailsService {

	StatusDto deviceDetails(DeviceDetailRequestDto request);

	public List<DeviceOrganizationDto> getAllDevice();
	

	public boolean updateDevice(DeviceDeactivateRequestDto deviceDeactivateRequest);

	StatusDto deviceData(String request, String device_uuid);

	ResponseEntity<List<DeviceDetailsModel>> companyDeviceDetails(int companyid);

	ResponseEntity<Object> getDeviceData(DeviceDataRequestDto deviceData);

	ResponseEntity<Object> getDeviceDataKeys(String uuid);

	ResponseEntity<Object> deviceDataByUuid(String deviceUuid);

	public StatusDto removeDeviceUsingId(Long devId);

	public StatusDto updateDevice(DeviceDetailRequestDto deviceRequest);
	
	

}
