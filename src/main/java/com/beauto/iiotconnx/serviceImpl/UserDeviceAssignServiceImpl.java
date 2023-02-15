package com.beauto.iiotconnx.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauto.iiotconnx.dto.DeviceOrganizationDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.dto.UserDevice;
import com.beauto.iiotconnx.dto.UserDevices;
import com.beauto.iiotconnx.model.DeviceDetailsModel;
import com.beauto.iiotconnx.model.UserDeviceAssignModel;
import com.beauto.iiotconnx.repository.DeviceDetailsRepo;
import com.beauto.iiotconnx.repository.UserDeviceRepo;
import com.beauto.iiotconnx.service.UserDeviceAssignService;

@Service
public class UserDeviceAssignServiceImpl implements UserDeviceAssignService {

	@Autowired
	private UserDeviceRepo userRepo;
	@Autowired
	private DeviceDetailsRepo ddr;

	
	public StatusDto saveUserDevices(UserDevices userDevices) {
		UserDeviceAssignModel userDeviceAssignModel = null;
		DeviceDetailsModel ddm = null;
		List<UserDevice> list = userDevices.getUserDevice();
		Integer userId = userDevices.getUserId();
		List<UserDeviceAssignModel> list1=userRepo.getDevicesByuserId(userDevices.getUserId());
		for(UserDeviceAssignModel c:list1)
		{
			userRepo.deleteById(c.getUserDeviceAssignId());
		}
		
		
		for (UserDevice userdevice : list) {
			userDeviceAssignModel = new UserDeviceAssignModel();
			ddm = ddr.findBydevId(userdevice.getDevId());
			System.out.println(ddm.toString());
			userDeviceAssignModel.setDeviceModel(ddm);
			userDeviceAssignModel.setUserId(userId);
			userRepo.save(userDeviceAssignModel);
		}
		StatusDto response = new StatusDto();
		response.setCode("200");
		response.setMessage("Success");
		return response;
	}

	@Override
	public List<DeviceOrganizationDto> getalldevicesByid(int userId) {
		List<UserDeviceAssignModel> udm = userRepo.getDevicesByuserId(userId);
		DeviceOrganizationDto deviceOrganizationDto = null;
		
		List<DeviceOrganizationDto> deviceOrganizationDtoList = new ArrayList<DeviceOrganizationDto>();
		for (UserDeviceAssignModel u : udm) {
			if(u.getDeviceModel().getDeleted_Flag().equalsIgnoreCase("False"))
			{
			deviceOrganizationDto = new DeviceOrganizationDto();
			deviceOrganizationDto.setCompanyName(u.getDeviceModel().getOrg().getCompanyName());
			deviceOrganizationDto.setDeviceId(u.getDeviceModel().getDevId() + "");
			deviceOrganizationDto.setDeviceName(u.getDeviceModel().getDeviceName());
			deviceOrganizationDto.setDeviceStatus(u.getDeviceModel().getDeviceStatus());
			deviceOrganizationDto.setDeviceUIID(u.getDeviceModel().getDeviceUIID());
			deviceOrganizationDto.setManufactId(u.getDeviceModel().getManufactId());
			deviceOrganizationDto.setProductName(u.getDeviceModel().getProductName());
			deviceOrganizationDto.setRegiDate(u.getDeviceModel().getRegiDate());
			deviceOrganizationDto.setUpdateAt(u.getDeviceModel().getUpdateAt());
			deviceOrganizationDtoList.add(deviceOrganizationDto);
			}
		}

		return deviceOrganizationDtoList;
	}

}
