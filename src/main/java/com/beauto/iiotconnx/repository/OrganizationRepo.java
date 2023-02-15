package com.beauto.iiotconnx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.Organization;
@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Integer> {

	public Organization getOrganizationByCompanyName(String companyName);

	public Organization findByCompanyName(String companyName);
	
	Organization findBycompanyId(int companyId);
	
	
	
	
	
}
