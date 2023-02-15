
package com.beauto.iiotconnx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beauto.iiotconnx.dto.DeviceDataRequestDto;
import com.beauto.iiotconnx.dto.DeviceDeactivateRequestDto;
import com.beauto.iiotconnx.dto.DeviceDetailRequestDto;
import com.beauto.iiotconnx.dto.DeviceOrganizationDto;
import com.beauto.iiotconnx.dto.DeviceResponseDto;
import com.beauto.iiotconnx.dto.OutputDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.model.DeviceDetailsModel;
import com.beauto.iiotconnx.service.DeviceDetailsService;

import lombok.extern.log4j.Log4j2;

/**
 * @author Abhijit jadhav
 * @date 12/01/2023
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j2
public class DeviceController {

	@Autowired
	DeviceDetailsService deviceDetails;


	@PostMapping("/devicedetails")
	public StatusDto deviceDetails(@Valid @RequestBody DeviceDetailRequestDto request) {
		log.info("Executing :: DeviceController.deviceDetails(DeviceDetailRequestDto request) " + request);
		StatusDto response=new StatusDto();
		
		//DeviceDetailsModel devicemodel=new DeviceDetailsModel();
		
		if(request.getDevId()==0) {

			 response= deviceDetails.deviceDetails(request);
		
		}else {
			response =deviceDetails.updateDevice(request);
			
		}

		return response; 

	}

	@GetMapping("/getAllDevice")
	public ResponseEntity<List<DeviceOrganizationDto>> getAllDevice() {

		log.info("Executing :: DeviceController.getAllDevice() ");

		try {

			List<DeviceOrganizationDto> getalldevice = new ArrayList<DeviceOrganizationDto>();

			deviceDetails.getAllDevice().forEach(getalldevice::add);

			if (getalldevice.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(getalldevice, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteDevice/{devId}")
	public StatusDto removeDevice(@PathVariable("devId") Long devId) {
		log.info("Executing :: DeviceController.removeDevice(Long devId) " + devId);

		StatusDto response=new StatusDto();
		
	 

		try {
 			 response = deviceDetails.removeDeviceUsingId(devId);
			

		} catch (Exception e) {

			log.info("Exception in deleteDevice Api : " + e.getMessage());
		}
		return response;
	}


	@RequestMapping(value = "/deactivateDevice", method = RequestMethod.PUT)
	public DeviceResponseDto<Boolean> deactivateDevice(
			@RequestBody DeviceDeactivateRequestDto deviceDeactivateRequest) {

		DeviceResponseDto<Boolean> response = new DeviceResponseDto<>();
		OutputDto<Boolean> result = new OutputDto<>();

		try {
			if (null != deviceDeactivateRequest) {

				boolean isDeviceDeactivate = deviceDetails.updateDevice(deviceDeactivateRequest);
				if (isDeviceDeactivate) {
					response.setResponseCode("200");
					response.setResponseMessage("Device deactivated sucess");
					result.setResponseData(isDeviceDeactivate);
					response.setResult(result);

				} else {
					response.setResponseCode("E401");
					response.setResponseMessage("Invalid device not deactivate");

				}
			} else {
				response.setResponseCode("E401");
				response.setResponseMessage("Invalid");

			}

		} catch (Exception e) {

			e.getMessage();
		}

		return response;
	}
	
	@PostMapping("/devicedata/{uuid}")
	public ResponseEntity<Object> deviceData(@PathVariable String uuid, @RequestBody String request) {
		log.info("Executing :: DeviceController.deviceData(@PathVariable String uuid,@RequestBody String request) "
				+ request);
		StatusDto status = deviceDetails.deviceData(request, uuid);

		return ResponseEntity.ok().body(status);
	}

	@RequestMapping(value = "/companydevicedata/{companyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeviceDetailsModel>> companyDeviceData(@PathVariable int companyId) {
		ResponseEntity<List<DeviceDetailsModel>> response = deviceDetails.companyDeviceDetails(companyId);
		return response;

	
	}

	@GetMapping("/devicedatakeys/{uuid}")
	public ResponseEntity<Object> deviceDataKeys(@PathVariable String uuid) {
		log.info("Executing :: DeviceController.deviceData(@PathVariable String uuid,@RequestBody String request) "
				+ uuid);
		ResponseEntity<Object> status = deviceDetails.getDeviceDataKeys(uuid);

		return status;
	}

	@PostMapping("/devicedata")
	public ResponseEntity<Object> getDeviceData(@RequestBody DeviceDataRequestDto dataRequest) {
		ResponseEntity<Object> datalist = deviceDetails.getDeviceData(dataRequest);

		return datalist;
	}

	@PostMapping("/devicedatabyuuid/{uuid}")
	public ResponseEntity<Object> getDeviceDataByUiid(@PathVariable String uuid) {
		ResponseEntity<Object> datalist = deviceDetails.deviceDataByUuid(uuid);

		return datalist;
	}

	
}
