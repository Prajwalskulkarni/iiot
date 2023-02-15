package com.beauto.iiotconnx.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrganizationDto {
	private int companyId;
	private String companyName;
	private String gstNo;
	private String pancard;
	private String dateReg;
	private String companyType;
	private  String SubcriptionStatus;
}
