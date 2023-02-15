package com.beauto.iiotconnx.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.beauto.iiotconnx.dto.DeviceDataRequestDto;
import com.beauto.iiotconnx.dto.DeviceDeactivateRequestDto;
import com.beauto.iiotconnx.dto.DeviceDetailRequestDto;
import com.beauto.iiotconnx.dto.DeviceOrganizationDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.model.DeviceDataModel;
import com.beauto.iiotconnx.model.DeviceDetailsModel;
import com.beauto.iiotconnx.model.Organization;
import com.beauto.iiotconnx.model.UserDeviceAssignModel;
import com.beauto.iiotconnx.repository.DeviceDataRepo;
import com.beauto.iiotconnx.repository.DeviceDetailsRepo;
import com.beauto.iiotconnx.repository.OrganizationRepo;
import com.beauto.iiotconnx.service.DeviceDetailsService;

@Service("DeviceDetailsService")
public class DeviceDetailsServiceImpl implements DeviceDetailsService {

	@Autowired
	DeviceDetailsRepo deviceRepo;

	@Autowired
	DeviceDataRepo deviceData;

	@Autowired
	OrganizationRepo org;

	// Log Device details in database
	@Transactional
	@Override
	public StatusDto deviceDetails(DeviceDetailRequestDto request) {
		// TODO Auto-generate method stub

		StatusDto status = new StatusDto();

		DeviceDetailsModel modelRes = null;
		Organization organization = org.findBycompanyId(Integer.parseInt(request.getCompanyId()));

		if (null == organization) {

		} else {

			DeviceDetailsModel model = mappingDeviceDetails(request, organization);

			modelRes = deviceRepo.save(model);
			status.setCode("200");
			status.setMessage("added successfully");
		}

		return status;
	}

	// Mapping request dto with device details model
	DeviceDetailsModel mappingDeviceDetails(DeviceDetailRequestDto request, Organization organization) {

		DeviceDetailsModel model = new DeviceDetailsModel();

		model.setDeviceName(request.getDeviceName());
		model.setDeviceStatus("active");
		model.setManufactId(request.getManufactId());
		model.setProductName(request.getProductName());
		model.setRegiDate(new Date());
		model.setDeleted_Flag("False");
		model.setUpdateAt(new Date());
		model.setOrg(organization);
        model.setDeviceUIID(UUID.randomUUID().toString());
		return model;

	}

	@Override
	public List<DeviceOrganizationDto> getAllDevice() {
		
		List<DeviceDetailsModel> udm = deviceRepo.findAll();
		DeviceOrganizationDto deviceOrganizationDto = null;
		
		List<DeviceOrganizationDto> deviceOrganizationDtoList = new ArrayList<DeviceOrganizationDto>();
		for (DeviceDetailsModel u : udm) {
			if(u.getDeleted_Flag().equalsIgnoreCase("False"))
			{
			deviceOrganizationDto = new DeviceOrganizationDto();
			deviceOrganizationDto.setCompanyName(u.getOrg().getCompanyName());
			deviceOrganizationDto.setDeviceId(u.getDevId() + "");
			deviceOrganizationDto.setDeviceName(u.getDeviceName());
			deviceOrganizationDto.setDeviceStatus(u.getDeviceStatus());
			deviceOrganizationDto.setDeviceUIID(u.getDeviceUIID());
			deviceOrganizationDto.setManufactId(u.getManufactId());
			deviceOrganizationDto.setProductName(u.getProductName());
			deviceOrganizationDto.setRegiDate(u.getRegiDate());
			deviceOrganizationDto.setUpdateAt(u.getUpdateAt());
			deviceOrganizationDtoList.add(deviceOrganizationDto);
			}
		}
		
		return deviceOrganizationDtoList;

	}

	@Override
	public boolean updateDevice(DeviceDeactivateRequestDto deviceDeactivateRequest) {

		boolean flag = false;
		try {

			DeviceDetailsModel deviceDetails = deviceRepo.getReferenceById(deviceDeactivateRequest.getDeviceId());

			if (null != deviceDetails) {
				if (deviceDetails.getDevId() == deviceDeactivateRequest.getDeviceId()) {
					deviceDetails.setDeviceStatus(deviceDeactivateRequest.getDeviceStatus());
					deviceDetails.setUpdateAt(new Date());
					deviceRepo.save(deviceDetails);
					flag = true;

				}

			}

		} catch (Exception e) {

			e.getMessage();

		}

		return flag;

	}

	// Logging Device data in Database
	@Transactional
	@Override
	public StatusDto deviceData(String request, String device_uuid) {
		// TODO Auto-generated method stub

		DeviceDataModel device = new DeviceDataModel();
		StatusDto status = new StatusDto();
		// Gson g = new Gson();
		// String json = g.toJson(request);

		request = request.replaceAll("\\s", "");
		device.setData(request);
		device.setDeviceUUID(device_uuid);
		device.setDataAddedDate(new Date());

		deviceData.save(device);

		// deviceData.saveDeviceData(json, device_uuid);

		status.setCode("101");
		status.setMessage("Device Data Stored");

		return status;

	}

	@Override
	public ResponseEntity<List<DeviceDetailsModel>> companyDeviceDetails(int companyId) {
		// TODO Auto-generated method stub

		List<DeviceDetailsModel> device = null;
		Organization organization = org.findBycompanyId(companyId);

		if (null != organization) {
			device = deviceRepo.findByOrg(organization);
		}
		//return null;
		return ResponseEntity.ok().body(device);

		
	}

	@Override
	public ResponseEntity<Object> getDeviceData(DeviceDataRequestDto deviceDataRequest) {
		// TODO Auto-generated method stub

		List<String> dataList = deviceData.getDeviceData(deviceDataRequest.getKey(), deviceDataRequest.getUiid());

		return ResponseEntity.ok().body(dataList);
	}

	@Override
	public ResponseEntity<Object> getDeviceDataKeys(String uuid) {
		// TODO Auto-generated method stub
		Set<String> keySet = deviceData.getDeviceKeys(uuid);

		return ResponseEntity.ok().body(keySet);
	}

	@Override
	public ResponseEntity<Object> deviceDataByUuid(String deviceUuid) {
		// TODO Auto-generated method stub

		List<DeviceDataModel> list = deviceData.findByDeviceUUID(deviceUuid);
		return ResponseEntity.ok().body(list);
	}

	@Override
	public StatusDto removeDeviceUsingId(Long devId) {
		StatusDto status=new StatusDto();
		
		try {
			if (devId != null) {
				//deviceRepo.deleteBydevId(devId);
				DeviceDetailsModel dev= deviceRepo.findBydevId(devId);
				
				Organization organization = org.findBycompanyId(dev.getOrg().getCompanyId());
				
				if(organization==null) {
					status.setCode("500");
					status.setMessage(" organization  is not found so Device Not deleted");
					
				}
				else {
				dev.setDeviceName(dev.getDeviceName());
				dev.setDeviceStatus(dev.getDeviceStatus());
				dev.setManufactId(dev.getManufactId());
				dev.setProductName(dev.getProductName());
				dev.setRegiDate(dev.getRegiDate());
				dev.setUpdateAt(new Date());
				dev.setOrg(organization);
				dev.setDeviceUIID(dev.getDeviceUIID());
				dev.setDeleted_Flag("True");

				deviceRepo.save(dev);
				status.setCode("200");
				status.setMessage("Deleted  Device succesfully");
				
			}
			}
			else {
				status.setCode("500");
				status.setMessage(" DevId is not Provided so Device Not deleted");
				
			}
				
		} catch (Exception e) {

			System.out.println(e);
		}
		return status;
	}

	@Override
	public StatusDto updateDevice(DeviceDetailRequestDto deviceRequest) {
		StatusDto response = new StatusDto();

		Organization organization = org.findBycompanyId(Integer.parseInt(deviceRequest.getCompanyId()));

		if (null == organization) {
			response.setCode("500");
			response.setMessage("You should add organization");
			

		} else {
			
			DeviceDetailsModel dev= deviceRepo.findBydevId(deviceRequest.getDevId());
			
			dev.setDeviceName(deviceRequest.getDeviceName());
			dev.setDeviceStatus(deviceRequest.getDeviceStatus());
			dev.setManufactId(deviceRequest.getManufactId());
			dev.setProductName(deviceRequest.getProductName());
			dev.setRegiDate(dev.getRegiDate());
			dev.setUpdateAt(new Date());
			dev.setDeleted_Flag(dev.getDeleted_Flag());
			dev.setOrg(organization);
			dev.setDeviceUIID(dev.getDeviceUIID());

			deviceRepo.save(dev);
			response.setCode("200");
			response.setMessage("updated successfully");
		}

		return response;
		
	
		
	}
	
}
