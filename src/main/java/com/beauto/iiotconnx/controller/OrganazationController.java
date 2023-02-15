package com.beauto.iiotconnx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beauto.iiotconnx.dto.DeviceOrgDto;
import com.beauto.iiotconnx.dto.OrganizationDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.model.Organization;
import com.beauto.iiotconnx.repository.OrganizationRepo;
import com.beauto.iiotconnx.service.DeviceService;
import com.beauto.iiotconnx.service.OrganizationService;

import lombok.extern.log4j.Log4j2;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j2
public class OrganazationController {

	@Autowired
	private OrganizationService organizationservice;

	@Autowired
	private OrganizationRepo organizationrepo;
//	@Autowired
//	private DeviceService deviceService;

	@PostMapping(value = "/CreateOrg")
	public StatusDto createOrg(@RequestBody OrganizationDto org) {
		log.info("Executing :: OrganizationController.createOrg(OrganizationDto org)");

		Organization orga = organizationrepo.findByCompanyName(org.getCompanyName());
		StatusDto response = new StatusDto();
		if (org.getCompanyId() != 0) {

			response.setCode("400");
			response.setMessage("updated sucessfully ");
			organizationservice.updateOrg(org);
		}

		else {
			if (orga != null) {

				response.setCode("500");
				response.setMessage("this company alredy existed");
				return response;
			}

			else {
				organizationservice.createOrg(org);

				response.setCode("200");
				response.setMessage("Success");
				return response;
			}

		}
		return response;
	}

	@GetMapping(value = "/getallorg")
	public List<Organization> getAllOrg() {
		log.info("Executing :: OrganizationController.getAllOrg()");

		List<Organization> list = organizationservice.getAllOrg();
		return list;
	}

	@GetMapping(value = "/getorg/{companyName}")
	public Organization getOrg(@PathVariable("companyName") String companyName) {
		log.info("Executing :: OrganizationController.getOrg()");

		return organizationservice.getOrganizationByCompanyName(companyName);

	}

	@GetMapping("/getAllDivicesByCompanyId/{companyId}")
	public DeviceOrgDto getbyCompantId(@PathVariable("companyId") int companyId) {
		DeviceOrgDto dod = organizationservice.findBycompanyId(companyId);
		return dod;
	}

}
