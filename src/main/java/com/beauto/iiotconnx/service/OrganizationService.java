package com.beauto.iiotconnx.service;

import java.util.List;

import com.beauto.iiotconnx.dto.DeviceOrgDto;
import com.beauto.iiotconnx.dto.OrganizationDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.model.Organization;

public interface OrganizationService {
		public StatusDto createOrg(OrganizationDto org);
		public StatusDto updateOrg(OrganizationDto org);
		public Organization getOrganizationByCompanyName(String companyName);
		public List<Organization> getAllOrg();
		public  DeviceOrgDto findBycompanyId(int companyId);




		
		
		

		
}
