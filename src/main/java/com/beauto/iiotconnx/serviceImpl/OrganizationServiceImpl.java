
package com.beauto.iiotconnx.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauto.iiotconnx.dto.DeviceOrgDto;
import com.beauto.iiotconnx.dto.DeviceOrganizationDto;
import com.beauto.iiotconnx.dto.OrganizationDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.model.DeviceDetailsModel;
import com.beauto.iiotconnx.model.Organization;
import com.beauto.iiotconnx.repository.DeviceRepo;
import com.beauto.iiotconnx.repository.OrganizationRepo;
import com.beauto.iiotconnx.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	private OrganizationRepo organizationrepo;
	@Autowired
	private DeviceRepo deviceRepo;

	public StatusDto createOrg(OrganizationDto org) {
		Organization orga = organizationrepo.findByCompanyName(org.getCompanyName());
		StatusDto response = new StatusDto();
		if (orga != null) {
			response.setCode("500");
			response.setMessage("this companyname alredy existed");
			return response;
		} else {
			orga = new Organization();
			orga.setCompanyName(org.getCompanyName());
			orga.setGstNo(org.getGstNo());
			orga.setPancard(org.getPancard());
			orga.setDateReg(org.getDateReg());
			orga.setCompanyType(org.getCompanyType());
			orga.setSubcriptionStatus("Active");
			Organization saved = organizationrepo.save(orga);
			if (saved != null) {

				response.setCode("200");
				response.setMessage("Success");

			}
			return response;

		}
	}

	public StatusDto updateOrg(OrganizationDto org) {

		StatusDto response = new StatusDto();
		Organization orga = new Organization();
		orga.setCompanyId(org.getCompanyId());
		orga.setCompanyName(org.getCompanyName());
		orga.setGstNo(org.getGstNo());
		orga.setPancard(org.getPancard());
		orga.setDateReg(org.getDateReg());
		orga.setCompanyType(org.getCompanyType());
		orga.setSubcriptionStatus(org.getSubcriptionStatus());
		

			organizationrepo.save(orga);
			response.setCode("200");
			response.setMessage("update Success");

		
		return response;
	}

	public Organization getOrganizationByCompanyName(String companyName) {

		return organizationrepo.getOrganizationByCompanyName(companyName);
	}

	public List<Organization> getAllOrg() {
		List<Organization> list = organizationrepo.findAll();
		return list;
	}

	@Override
	public DeviceOrgDto findBycompanyId(int companyId) {
		DeviceOrgDto deviceorgDto=new DeviceOrgDto();
		DeviceOrganizationDto dod = null;
		List<DeviceOrganizationDto> dtoList=new ArrayList<DeviceOrganizationDto>();
		List<DeviceDetailsModel> devices = deviceRepo.findAll();
		deviceorgDto.setCompanyName(devices.get(0).getOrg().getCompanyName());
		for (DeviceDetailsModel o : devices) {
			
			if (o.getOrg().getCompanyId() == companyId) {
				dod = new DeviceOrganizationDto();
				dod.setDeviceName(o.getDeviceName());
				dod.setDeviceStatus(o.getDeviceStatus());
				dod.setDeviceUIID(o.getDeviceUIID());
				dod.setManufactId(o.getManufactId());
				dod.setProductName(o.getProductName());
				dod.setRegiDate(o.getRegiDate());
				dod.setUpdateAt(o.getUpdateAt());
				dod.setDeviceId(o.getDevId()+"");
				dtoList.add(dod);
			}
		}
		deviceorgDto.setDeviceorgindto(dtoList);
		return deviceorgDto;
	}

}