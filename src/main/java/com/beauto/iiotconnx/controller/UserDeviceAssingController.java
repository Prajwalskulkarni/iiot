package com.beauto.iiotconnx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beauto.iiotconnx.dto.DeviceOrganizationDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.dto.UserDevices;
import com.beauto.iiotconnx.service.UserDeviceAssignService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserDeviceAssingController {
	@Autowired
	private UserDeviceAssignService userService;

	@PostMapping("/deviceassign")
	public StatusDto saveUser(@RequestBody UserDevices userDevices) {
		StatusDto responseVe = userService.saveUserDevices(userDevices);

		return responseVe;
	}
	 
	  @GetMapping("/getdevices/{userId}") 
	  public List<DeviceOrganizationDto>getAlldevicesById(@PathVariable("userId")int userId){ return
	 userService.getalldevicesByid(userId); }
	 
}